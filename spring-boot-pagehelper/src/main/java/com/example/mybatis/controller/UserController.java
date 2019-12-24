package com.example.mybatis.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.entity.User;
import com.example.mybatis.service.UserService;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @RequestMapping("get/{id}")
    public String getUser(@PathVariable int id){
        return userService.selectUser(id).toString();
    }
    @RequestMapping("getAll")
    public String getAllUsers(){
        int count = 0;
    	List<User> users = userService.selectAllUsers();
        if (null != users && users.size() > 0) {
        	count = users.size();
        }
        
        return "Find " + count + " users.";
    }

    @RequestMapping("getPagedAll")
    public String getPagedAllUsers(){
        int count = 0;
        PageHelper.startPage(1, 10);
        
    	List<User> users = userService.selectAllUsers();
        if (null != users && users.size() > 0) {
        	count = users.size();
        }
        
        return "Using PageHelper. Find " + count + " users.";
    }

    @RequestMapping("genUsers")
    public String genUsers(@RequestParam int count) {
    	for (int i=2; i<count+2; i++) {
    		String str = UUID.randomUUID().toString().substring(16);
    		User user = new User();
    		user.setId(i);
    		user.setUserName(str);
    		user.setRealName(str);
    		user.setPassWord(str);
    		
    		userService.saveUser(user);
    	}
    	return "生成了" + count + "个用户。";
    }
}
