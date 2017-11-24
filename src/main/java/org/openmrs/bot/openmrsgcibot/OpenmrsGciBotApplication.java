package org.openmrs.bot.openmrsgcibot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class OpenmrsGciBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenmrsGciBotApplication.class, args);
	}

	@Bean
	public Config botConfig() throws IOException {
		final ObjectMapper mapper = new ObjectMapper();
		final InputStream in = this.getClass().getResourceAsStream("/config.json");
		final Config config = mapper.readValue(in, Config.class);
		return config;
	}
}
