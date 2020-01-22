package com.example.quartz.config;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.example.quartz.job.SpringQuartzJob;

@Configuration
public class SpringQuartzConfig {

	@Bean
	JobDetailFactoryBean jobDetail() {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("name", "Kevin Zhang");

		JobDetailFactoryBean bean = new JobDetailFactoryBean();
		
		bean.setJobClass(SpringQuartzJob.class);
		bean.setJobDataMap(jobDataMap);
		
		return bean;
	}
	
	@Bean
	CronTriggerFactoryBean cronTrigger() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setCronExpression("0/30 * * * * ?");//每隔30秒执行1次
		bean.setJobDetail(jobDetail().getObject());
		return bean;
	}
	
	@Bean
	SchedulerFactoryBean scheduler() {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		CronTrigger trigger = cronTrigger().getObject();
		bean.setTriggers(trigger);
		return bean;
	}
	
}
