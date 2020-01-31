package com.example.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.config.dao.UserDAO;
import com.example.config.entity.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	public User getUser(int id) {
		return userDAO.getUser(id);
	}

}
