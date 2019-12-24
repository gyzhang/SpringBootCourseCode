package com.example.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.entity.User;
import com.example.mongodb.service.UserService;

@RestController
@RequestMapping("/mongodb/user/")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/save")
	public String save(String id, String name, int age) {
		return userService.save(id, name, age);
	}
	
	@RequestMapping("/findAll")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@RequestMapping("/get")
	public User get(String id) {
		return userService.get(id);
	}
	
	@RequestMapping("/update")
	public String update(String id, String name, int age) {
		return userService.update(id, name, age);
	}
	
	@RequestMapping("/delete")
	public String delete(String id, String name, int age) {
		return userService.delete(id, name, age);
	}

}
