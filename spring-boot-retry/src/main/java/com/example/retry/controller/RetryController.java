package com.example.retry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retry.service.RetryService;

@RestController
@RequestMapping("/retry/")
public class RetryController {
	
	@Autowired 
	RetryService service;
	
	@RequestMapping("/service")
	public String service(int code) throws Exception {
		int result = service.service(code);
		return "spring-retry in Spring Boot: "+ result;
	}

}
