package com.example.oauth2.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.oauth2.entity.SysUser;

@Service
public class UserDetailService implements UserDetailsService, Serializable {
	private static final long serialVersionUID = 4332055236047478860L;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = new SysUser();
        user.setUsername(username);
        user.setPassword(this.passwordEncoder.encode("123456"));
        return new User(username, user.getPassword(), user.isEnabled(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER,ROLE_OTHER"));
    }
}
