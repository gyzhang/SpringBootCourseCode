package com.example.exception.component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExExceptionHandler {

	@ExceptionHandler(DemoException.class)
	public String handleException(Exception e, HttpServletRequest request) {
		request.setAttribute("javax.servlet.error.status_code", 500);
		request.setAttribute("extErrorMsg", "演示用异常，扩展信息。");
		return "forward:/error";
	}

}
