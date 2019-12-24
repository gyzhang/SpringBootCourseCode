package com.example.hello.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
	@Value("${net.xprogrammer.author}")
	private String author;
	
	@Value("${net.xprogrammer.book}")
	private String book;
	
	@RequestMapping("/hello")
	@CrossOrigin(origins = "*")
	public String sayHello() {
		return "Hello Spring Boot. Author=" + author + ", Book=" + book;
	}
	
	@RequestMapping("/register")
	@CrossOrigin(origins = "*")
	public String register(String name, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> users = (List<String>) session.getAttribute("users");
		if (users == null || users.size() <= 0) {
			users = new ArrayList<>();
		}
		users.add(name);
		session.setAttribute("users", users);
		
		return name + " Registered.";
	}

	@RequestMapping("/getUsers")
	@CrossOrigin(origins = "*")
	public List<String> getUsers(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> users = (List<String>) session.getAttribute("users");
		if (users == null || users.size() <= 0) {
			users = new ArrayList<>();
		}
		
		return users;
	}
	
}
