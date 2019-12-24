package com.example.activemq.topic.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
	
	/**
	 * 消息消费者1，监听"Topic-Weather"上的消息
	 * @param msg 消息
	 */
	@JmsListener(destination = "Topic-Weather")
	public void subscriber1(String msg) {
		System.out.println("Consumer1 consume message: " + msg);
	}

	/**
	 * 消息消费者2，监听"Topic-Weather"上的消息
	 * @param msg 消息
	 */
	@JmsListener(destination = "Topic-Weather")
	public void subscriber2(String msg) {
		System.out.println("Consumer2 consume message: " + msg);
	}

}
