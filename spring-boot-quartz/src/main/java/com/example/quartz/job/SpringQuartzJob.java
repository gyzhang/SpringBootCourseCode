package com.example.quartz.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 使用Spring提供的Quartz集成API方式
 * @author Kevin
 *
 */
public class SpringQuartzJob extends QuartzJobBean {
	private String name;
	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Spring Quartz Job say hello to " + name + ": " + new Date());
	}

}
