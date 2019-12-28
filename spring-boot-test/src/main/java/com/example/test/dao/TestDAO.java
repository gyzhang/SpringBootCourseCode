package com.example.test.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {

	//模拟从数据库访问数据后返回用户的年龄
	public int getUserAge(String userId) {
		int result = 0;
		if (userId.equals("kevin")) {
			result = 18;
		} else if (userId.equals("roy")) {
			result = 12;
		} else {
			result = 28;
		}
		
		return result;
	}
}
