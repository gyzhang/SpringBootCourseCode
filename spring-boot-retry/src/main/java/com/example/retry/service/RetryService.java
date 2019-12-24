package com.example.retry.service;

import java.time.LocalTime;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

	@Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
	public int service(int code) throws Exception {
		System.out.println("service called: " + LocalTime.now());
		if (code == 0) {
			throw new Exception("EXCCEPTION: It's bad.");
		}
		System.out.println("service called, it's good.");
		return 200;
	}
	
	@Recover
    public int recover(Exception e){
        System.out.println("retry recover.");
        return 500;
    }

}
