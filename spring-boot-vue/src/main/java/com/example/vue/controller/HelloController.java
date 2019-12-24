package com.example.vue.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	@CrossOrigin(origins = "*")
	public String hello() {
		return "Hello Spring Boot.";
	}

}
