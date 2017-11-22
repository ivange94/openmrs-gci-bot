package org.openmrs.bot.openmrsgcibot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.bot.openmrsgcibot.Config;
import org.openmrs.bot.openmrsgcibot.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    @Autowired
    private Config config;

    @RequestMapping(value = "notifications", method = RequestMethod.POST)
    public ResponseEntity receiveNotifications(@RequestBody Message message) {

        System.out.println(config);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}