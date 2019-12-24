package com.example.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @RequestMapping("get/{id}")
    public String getUser(@PathVariable int id){
        return userService.selectUser(id).toString();
    }
    
}
