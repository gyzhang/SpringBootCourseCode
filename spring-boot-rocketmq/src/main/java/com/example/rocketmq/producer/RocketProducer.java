package com.example.rocketmq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RocketProducer {
	
	@Autowired
	private RocketMQTemplate rocketMQTemplate;
	
	public void sendMessage(String msg) {
		rocketMQTemplate.convertAndSend("test-topic",msg);
	}

}
