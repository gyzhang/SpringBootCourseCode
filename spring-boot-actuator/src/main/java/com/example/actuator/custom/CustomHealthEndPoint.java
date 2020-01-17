package com.example.actuator.custom;

import java.io.File;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

/**
 * 自定义监控示例，监控磁盘容量
 * @author Kevin
 *
 */
@Component("myHealth")
public class CustomHealthEndPoint extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		File[] rootFiles = File.listRoots();
		if (rootFiles != null && rootFiles.length != 0) {
			long total = 0, free = 0;
			for (File file : rootFiles) {
				total += file.getTotalSpace(); // 磁盘总量
				free += file.getUsableSpace(); // 可用容量
			}
			long user = total - free; // 已用容量
			double userRate = total == 0 ? 0 : ((double) user / total);// 磁盘利用率
			builder.up()
				.withDetail("磁盘总量", total) // 这里是你要显示的具体健康监测信息
				.withDetail("可用容量", free)
				.withDetail("利用率%", userRate * 100).build();
		} else {
			builder.down().build();
		}
	}

}
