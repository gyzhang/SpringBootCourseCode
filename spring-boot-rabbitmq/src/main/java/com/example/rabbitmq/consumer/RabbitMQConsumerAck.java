package com.example.rabbitmq.consumer;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
@RabbitListener(queues = {"lily"})
public class RabbitMQConsumerAck {

    @RabbitHandler
    public void process(String sendMsg, Channel channel, Message message) {
    	System.out.println("RabbitMQ ConsumerAck consume message: " + sendMsg + " @" + LocalDateTime.now(ZoneId.systemDefault()));
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            System.out.println("Process Success");
        } catch (Exception e) {
            System.out.println("Process Failure.");
            e.printStackTrace();
        }
    }
}
