package com.example.rocketmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rocketmq.producer.RocketProducer;

@RestController
@RequestMapping("/rocketmq/")
public class RocketController {

	@Autowired
	RocketProducer rocketProducer;
	
	@RequestMapping("/send")
	public String sendMsg(String msg) {
		rocketProducer.sendMessage(msg);
		return msg + " Sended to test-topic.";
	}
}
