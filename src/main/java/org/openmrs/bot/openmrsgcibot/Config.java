package org.openmrs.bot.openmrsgcibot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Config {

    private String gciApiKey;

    private String telegramApiKey;

    private Long telegramChatId;

    public String getGciApiKey() {
        return gciApiKey;
    }

    public void setGciApiKey(String gciApiToken) {
        this.gciApiKey = gciApiToken;
    }

    public String getTelegramApiKey() {
        return telegramApiKey;
    }

    public void setTelegramApiKey(String telegramApiKey) {
        this.telegramApiKey = telegramApiKey;
    }

    public Long getTelegramChatId() {
        return telegramChatId;
    }

    public void setTelegramChatId(Long telegramChatId) {
        this.telegramChatId = telegramChatId;
    }

    @Override
    public String toString() {
        final ObjectMapper mapper = new ObjectMapper();
        String configAsJson = "[gciApiToken= " + getGciApiKey() + ", telegramBotToken= " + getTelegramApiKey() + " ]";
        try {
            configAsJson = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return configAsJson;
    }
}
