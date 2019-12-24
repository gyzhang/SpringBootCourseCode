package com.example.activemq.topic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.activemq.topic.producer.TopicProducer;

@RestController
@RequestMapping("/activemq/")
public class TopicController {
	@Autowired
	private TopicProducer topicProducer;

	@RequestMapping("/send")
	public String sendMsg(String msg) {
		topicProducer.sendMessage(msg);
		return msg + " Sended to Topic-Weather.";
	}

}
