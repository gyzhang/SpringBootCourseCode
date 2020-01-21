package com.example.quartz.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import com.example.quartz.job.HelloJob;

/**
 * Quartz调度器示例
 * @author Kevin
 *
 */
@Service
public class TestQuartz {

	public TestQuartz() {
		Scheduler scheduler;
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			System.out.println(scheduler.getSchedulerName() + " - " + scheduler.getSchedulerInstanceId());
			
			JobDetail jobDetail = JobBuilder
				    .newJob(HelloJob.class)
				    .withIdentity("helloJob", "groupName")
				    .build();
			
			String cronExpression = "0 0/1 22,23 * * ?";//每晚10点-11点，每隔1分钟执行1次
			CronTrigger trigger = TriggerBuilder.newTrigger()
			    .withIdentity("helloTrigger", "trigger_group")// 触发器名,触发器组
			    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
			    .build();
			
			scheduler.scheduleJob(jobDetail, trigger);//Scheduler绑定job和trigger
			
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
