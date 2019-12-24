package com.example.jdbctemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jdbctemplate.dao.UserDAO;
import com.example.jdbctemplate.entity.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	public User getUser(int id) {
		return userDAO.getUser(id);
	}

}
