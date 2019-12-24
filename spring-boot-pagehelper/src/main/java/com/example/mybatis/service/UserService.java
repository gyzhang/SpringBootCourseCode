package com.example.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;

@Service
@Transactional(readOnly = true)
public class UserService {
    @Autowired
    UserMapper userMapper;
    
    public User selectUser(int id){
        return userMapper.selectUser(id);
    }

    public List<User> selectAllUsers(){
        return userMapper.selectAllUsers();
    }
    
    @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
    public void saveUser(User user) {
    	userMapper.saveUser(user);
    }
    
}
