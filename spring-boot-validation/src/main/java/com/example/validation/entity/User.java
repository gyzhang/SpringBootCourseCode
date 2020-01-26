package com.example.validation.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Validated
public class User {
	@Size(min = 2, max = 10, message = "用户名必须大于2个字，并且小于10个字。")
	private String name;

	@Length(min = 6, max = 12, message = "密码长度必须在1~12位之间。")
	private String password;
	
	@Max(value = 100, message = "非法年龄。")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
