package com.example.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User selectUser(int id){
        return userMapper.selectUser(id);
    }

}
