package org.openmrs.bot.openmrsgcibot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class OpenmrsGciBotApplication {

	@Autowired
	private ResourceLoader resourceLoader;

	public static void main(String[] args) {
		SpringApplication.run(OpenmrsGciBotApplication.class, args);
	}

	@Bean
	public Config botConfig() throws IOException {
		final ObjectMapper mapper = new ObjectMapper();
		final File configFile = resourceLoader.getResource("classpath:config.json").getFile();
		final Config config = mapper.readValue(configFile, Config.class);
		return config;
	}
}
