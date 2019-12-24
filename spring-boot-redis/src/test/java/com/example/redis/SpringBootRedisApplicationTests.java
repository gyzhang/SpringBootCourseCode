package com.example.redis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBootRedisApplicationTests {

	@Resource
	private StringRedisTemplate strTemplate;

	@Test
	public void testRedis() {
		strTemplate.opsForValue().set("name", "Kevin");
		String name = strTemplate.opsForValue().get("name");
		assertEquals("Kevin", name);
	}
}
