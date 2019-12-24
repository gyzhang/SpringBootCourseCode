package com.example.redis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisSessionController {

	@Value("${server.port}")
	String port;
	
	@RequestMapping("/save")
	public String save(HttpSession session) {
		session.setAttribute("name", "Kevin");
		return "success";
	}

	@RequestMapping("/get")
	public String get(HttpSession session) {
		String name = (String) session.getAttribute("name");
		return name + ", from Server Port: " + port;
	}

}
