package com.example.legacy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("helloListener: ServletContext Initialized.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("helloListener: ServletContext Destroyed.");
	}

}
