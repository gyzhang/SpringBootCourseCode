package com.example.actuator.custom;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("anotherCustomHealthEndPoint")
public class AnotherCustomHealthEndPoint implements HealthIndicator {

	@Override
	public Health health() {
        int errorCode = new Random().nextInt(5); // 定义一个错误代码 随机产生
        if (errorCode != 0) {
            return Health.down().withDetail("错误码：", errorCode).build();
        } else {
            return Health.up().withDetail("正确代码：", errorCode).build();
        }
	}

}
