package com.example.mongodb.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.entity.User;

public interface UserDAO extends MongoRepository<User, String> {
	public Page<User> findByNameLike(String name, Pageable pageable);
}
