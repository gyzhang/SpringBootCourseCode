package com.example.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch/")
public class JobController {
	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;
	
	@RequestMapping("/run")
	public String run() {
		String result = "STOP";
		try {
			jobLauncher.run(job, new JobParametersBuilder().toJobParameters());
			result = "RUN";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
