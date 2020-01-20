package com.example.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String from;

    public String sendMail(String to, String subject, String text) {
    	SimpleMailMessage message =	new SimpleMailMessage();
    	
    	message.setFrom(from);
    	message.setTo(to);
    	message.setSubject(subject);
    	message.setText(text);
    	
    	mailSender.send(message);
    	
    	return "Mail Sended.";
    }

}
