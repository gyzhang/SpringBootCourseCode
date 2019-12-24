package com.example.legacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.legacy.filter.HelloFilter;
import com.example.legacy.listener.HelloListener;
import com.example.legacy.servlet.HelloServlet;

@SpringBootApplication
@ServletComponentScan
public class SpringBootLegacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLegacyApplication.class, args);
	}

	// 注册Servlet
	@Bean
	public ServletRegistrationBean<HelloServlet> registerServlet() {
		ServletRegistrationBean<HelloServlet> servletRegistrationBean = new ServletRegistrationBean<HelloServlet>(
				new HelloServlet(), "/helloServlet");
		servletRegistrationBean.setName("helloServlet");
		servletRegistrationBean.setOrder(1);
		servletRegistrationBean.addInitParameter("firstName", "Kevin");
		servletRegistrationBean.addInitParameter("lastName", "Zhang");
		return servletRegistrationBean;
	}

	// 注册Filter
	@Bean
	public FilterRegistrationBean<HelloFilter> registerFilter() {
		FilterRegistrationBean<HelloFilter> filterRegistrationBean = new FilterRegistrationBean<HelloFilter>(
				new HelloFilter());
		filterRegistrationBean.setName("helloFilter");
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/");
		filterRegistrationBean.addInitParameter("firstName", "Kevin");
		filterRegistrationBean.addInitParameter("lastName", "Zhang");
		return filterRegistrationBean;
	}

	// 注册Listener
	@Bean
	public ServletListenerRegistrationBean<HelloListener> registerListener() {
		ServletListenerRegistrationBean<HelloListener> listenerRegistrationBean = new ServletListenerRegistrationBean<HelloListener>(
				new HelloListener());
		listenerRegistrationBean.setOrder(1);
		return listenerRegistrationBean;
	}
}
