package com.example.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 创建一个示例任务
 * @author Kevin
 *
 */
public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(System.currentTimeMillis() + " - HelloJob 执行"); 
	}

}
