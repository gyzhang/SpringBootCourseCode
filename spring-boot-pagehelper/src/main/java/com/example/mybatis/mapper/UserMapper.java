package com.example.mybatis.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.mybatis.entity.User;

@Repository
public interface UserMapper {

	User selectUser(int id);
	List<User> selectAllUsers();
	void saveUser(User user);
}
