package com.example.actuator.mapper;

import org.springframework.stereotype.Repository;

import com.example.actuator.entity.SysUser;

@Repository
public interface SysUserMapper {

	SysUser selectSysUser(String username);

}
