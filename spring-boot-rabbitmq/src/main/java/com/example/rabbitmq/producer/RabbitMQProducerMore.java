package com.example.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducerMore {
	
	@Autowired 
	AmqpTemplate amqpTemplate;
	
	public void sendMessage(String msg) {
		amqpTemplate.convertAndSend("roy", msg);
	}

}
