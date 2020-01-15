package com.example.actuator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actuator.entity.SysUser;
import com.example.actuator.mapper.SysUserMapper;

@Service
public class SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;
	
	public SysUser selectSysUser(String username) {
		return sysUserMapper.selectSysUser(username);
	}
	
	

}
