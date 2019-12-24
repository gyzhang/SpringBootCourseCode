package com.example.exception.foo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.component.DemoException;

@RestController
@RequestMapping("/exception/")
public class TestController {
	
	@RequestMapping("/demoException")
	public String serverError() {
		throw new DemoException();
	}

	@RequestMapping("/serverError")
	public String serverError2() {
		double d = 100/0;
		return "error" + d;
	}
}
