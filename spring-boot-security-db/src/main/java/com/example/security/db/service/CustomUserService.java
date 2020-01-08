package com.example.security.db.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.security.db.entity.SysUser;
import com.example.security.db.entity.SysUserRole;
import com.example.security.db.mapper.SysUserMapper;
import com.example.security.db.mapper.SysUserRoleMapper;

public class CustomUserService implements UserDetailsService {
	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser = sysUserMapper.selectSysUser(username);
		String password = sysUser.getPassword();
		List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectSysUserRole(username);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (SysUserRole sysUserRole : sysUserRoles) {
			authorities.add(new SimpleGrantedAuthority(sysUserRole.getRoleCode()));
		}

		return new User(username, password, authorities);
	}

}
