package com.example.validation.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.entity.User;

@RestController
@RequestMapping("/validation/")
public class UserController {

	@PostMapping("/hello")
	public String sayHello(@Valid @RequestBody User user, BindingResult results) {
		if (results.hasErrors()) {
			return "请求参数校验错误：" + 
		           results.getFieldError().getDefaultMessage();
		}
		return "success";
	}

}
