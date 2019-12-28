package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.service.TestService;

@RestController
@RequestMapping("/test/")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/getUserAge")
	public String getUserAge(String userId) {
		int age = testService.getUserAge(userId);
		return "User[" + userId + "]'s age is: " + age + ".";
	}

}
