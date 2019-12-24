package com.example.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
    @KafkaListener(topics = {"KafkaTopic"})
    public void listen(ConsumerRecord<?, ?> record) {
    	System.out.println("RocketMQ Consumer consume message: " + record.value());
    }

}
