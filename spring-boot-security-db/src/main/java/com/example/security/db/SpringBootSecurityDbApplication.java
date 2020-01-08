package com.example.security.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.security.db.mapper")
public class SpringBootSecurityDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDbApplication.class, args);
	}

}
