package com.example.war.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/")
public class HelloController {
	
	@RequestMapping("/greeting")
	public String greeting(String name) {
		return "Hello, " + name + ".";
	}

}
