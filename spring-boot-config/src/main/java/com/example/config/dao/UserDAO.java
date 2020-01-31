package com.example.config.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.config.entity.User;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public User getUser(int id) {
		String sql = "select * from user where id=" + id;
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
	}

}
