package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "kevin")
public class RabbitMQConsumer {
	
	@RabbitHandler
    public void receive(String msg) {
		System.out.println("RabbitMQ Consumer consume message: " + msg);
	}

}
