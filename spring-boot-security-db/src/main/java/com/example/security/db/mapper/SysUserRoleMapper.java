package com.example.security.db.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.security.db.entity.SysUserRole;

@Repository
public interface SysUserRoleMapper {

	List<SysUserRole> selectSysUserRole(String username);

}
