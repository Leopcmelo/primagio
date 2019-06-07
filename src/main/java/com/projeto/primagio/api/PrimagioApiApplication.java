package com.projeto.primagio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.projeto.primagio.api.config.property.PrimagioApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(PrimagioApiProperty.class)
public class PrimagioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimagioApiApplication.class, args);
	}

}
