package com.example.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mail.service.SendMailService;

@RestController
@RequestMapping("/mail/")
public class SendMailController {
	@Autowired
	private SendMailService sendMailService;

	@RequestMapping("/send")
	public String sendMail() {
		String to = "xxx@163.com";
		String subject = "你好，Spring Boot.";
		String text = "这是一封由Spring Boot应用程序自动发送的测试邮件，无可用信息，请直接删除。";
		return sendMailService.sendMail(to, subject, text);
	}

}
