package com.example.security.db.mapper;

import org.springframework.stereotype.Repository;

import com.example.security.db.entity.SysUser;

@Repository
public interface SysUserMapper {

	SysUser selectSysUser(String username);

}
