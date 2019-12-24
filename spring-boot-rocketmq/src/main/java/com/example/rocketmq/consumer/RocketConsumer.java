package com.example.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "my-consumer_test-topic", topic = "test-topic")
public class RocketConsumer implements RocketMQListener<String> {

	@Override
	public void onMessage(String message) {
		System.out.println("RocketMQ Consumer consume message: " + message);
	}

}
