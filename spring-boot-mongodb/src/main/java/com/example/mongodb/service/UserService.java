package com.example.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.mongodb.entity.User;

@Service
public class UserService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public String save(String id, String name, int age) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		
		mongoTemplate.save(user);
		return "success";
	}

	public List<User> findAll() {
		return mongoTemplate.findAll(User.class);
	}

	public User get(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, User.class);
	}

	public String update(String id, String name, int age) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		
		Query query = new Query(Criteria.where("_id").is(id));
		Update update = new Update().set("name", name).set("age", age);
		mongoTemplate.updateFirst(query, update, User.class);
		return "success";
	}
	
	public String delete(String id, String name, int age) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		
		mongoTemplate.remove(user);
		return "success";
	}
}
