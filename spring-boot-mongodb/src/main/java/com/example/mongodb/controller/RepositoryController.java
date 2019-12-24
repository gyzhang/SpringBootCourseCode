package com.example.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.dao.UserDAO;
import com.example.mongodb.entity.User;

@RestController
@RequestMapping("/mongodb/repository/")
public class RepositoryController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/createUser")
	public User createUser(User user) {
		return userDAO.save(user);
	}

	@RequestMapping("/findByNameLike")
	public Page<User> findByNameLike(String name) {
		PageRequest pageable = PageRequest.of(0, 10);
		return userDAO.findByNameLike(name, pageable);
	}
}
