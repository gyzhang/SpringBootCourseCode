package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "roy")
public class RabbitMQConsumer2 {
	
	@RabbitHandler
    public void receive(String msg) {
		System.out.println("RabbitMQ Consumer2 consume message: " + msg);
	}

}
