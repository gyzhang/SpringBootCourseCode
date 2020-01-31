package com.example.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootConfigApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootConfigApplication.class);
		builder.application().setAdditionalProfiles("dev");
		builder.run(args);
	}

}
