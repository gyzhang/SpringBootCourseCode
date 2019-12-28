package com.example.devtools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devtools/")
public class TestController {
	
	@RequestMapping("/test")
	public String hello() {
		return "Hello DevTools.";
	}

}
