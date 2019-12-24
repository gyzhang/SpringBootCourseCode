package com.example.mybatis.mapper;

import org.springframework.stereotype.Repository;

import com.example.mybatis.entity.User;

@Repository
public interface UserMapper {

	User selectUser(int id);
}
