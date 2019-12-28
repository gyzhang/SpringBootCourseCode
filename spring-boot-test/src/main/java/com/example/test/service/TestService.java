package com.example.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.TestDAO;

@Service
public class TestService {
	
	@Autowired
	TestDAO testDAO;
	
	public int getUserAge(String userId) {
		return testDAO.getUserAge(userId);
	}


}
