package com.example.security.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.db.entity.SysUser;
import com.example.security.db.service.SysUserService;

@RestController
public class SysUserController {
	
	@Autowired
	SysUserService service;
	
	@RequestMapping("/selectUser")
	public String selectUser(String username) {
		SysUser user = service.selectSysUser(username);
		return user.toString();
	}

}
