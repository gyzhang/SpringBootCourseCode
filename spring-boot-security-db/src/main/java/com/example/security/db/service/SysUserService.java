package com.example.security.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.db.entity.SysUser;
import com.example.security.db.mapper.SysUserMapper;

@Service
public class SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;
	
	public SysUser selectSysUser(String username) {
		return sysUserMapper.selectSysUser(username);
	}
	
	

}
