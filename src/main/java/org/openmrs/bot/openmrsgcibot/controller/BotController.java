package org.openmrs.bot.openmrsgcibot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openmrs.bot.openmrsgcibot.Config;
import org.openmrs.bot.openmrsgcibot.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@RestController
public class BotController {

    @Autowired
    private Config config;

    private static final String EventTypeComment = "comment";

    private static final String EventTypeSubmit = "submit";

    private static final String EventTypeNeedsWork = "needswork";

    private static final String EventTypeAbandon = "abandon";

    private static final String EventTypeClaim = "claim";

    private static final String EventTypeApprove = "approve";

    @RequestMapping(value = "notifications", method = RequestMethod.POST)
    public ResponseEntity<String> receiveNotifications(@RequestBody Message message) throws JsonProcessingException {

        sendUpdateToTelegramChannel(message);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private void sendUpdateToTelegramChannel(Message message) throws JsonProcessingException {
        final String text = getText(message);
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<?> entity = new HttpEntity<>(headers);
        restTemplate.exchange(
                    getUrl(),
                    HttpMethod.POST,
                    entity,
                    String.class,
                    config.getTelegramChatId(),
                    text
        );
    }

    private String getText(Message message) {
        final String template = "<OpenMRSGciBot> New from Google Code-in: " + message.getAuthor() + " {0} " + message.getTask_definition_name() + ". See " + message.getTask_instance_url();

        switch (message.getEvent_type()) {
            case EventTypeComment:
                return MessageFormat.format(template, " commented on ");
            case EventTypeSubmit:
                return MessageFormat.format(template, " submitted task for ");
            case EventTypeNeedsWork:
                return MessageFormat.format(template, " requested for more work on ");
            case EventTypeAbandon:
                return MessageFormat.format(template, " abandoned task ");
            case EventTypeClaim:
                return MessageFormat.format(template, " started working on ");
            case EventTypeApprove:
                return MessageFormat.format(template, " accepted a submission for ");
            default:
                return MessageFormat.format(template, " triggered unknown event for ");
        }
    }

    private String getUrl() {
        return "https://api.telegram.org/bot" + config.getTelegramApiKey() + "/sendMessage?chat_id={chat_id}&text={text}";
    }
}