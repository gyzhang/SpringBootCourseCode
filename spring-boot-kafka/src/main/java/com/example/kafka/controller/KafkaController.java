package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producer.KafkaProducer;

@RestController
@RequestMapping("/kafka/")
public class KafkaController {
	
	@Autowired
	KafkaProducer kafkaProducer;
	
	@RequestMapping("/send")
	public String sendMsg(String msg) {
		kafkaProducer.sendMessage(msg);
		return msg + " Sended to KafkaTopic.";
	}

}
