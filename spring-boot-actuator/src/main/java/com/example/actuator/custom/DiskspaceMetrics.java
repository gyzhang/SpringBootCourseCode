package com.example.actuator.custom;

import java.io.File;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

@Component("diskspaceMetrics")
public class DiskspaceMetrics implements MeterBinder {
	private File rootFilePath;

	public DiskspaceMetrics() {
		this.rootFilePath = new File(".");
	}

	@Override
	public void bindTo(MeterRegistry registry) {
		Gauge.builder("磁盘已用容量", rootFilePath, File::getTotalSpace).register(registry);
		Gauge.builder("磁盘剩余容量", rootFilePath, File::getFreeSpace).register(registry);
		Gauge.builder("磁盘使用率", rootFilePath, c -> {
			long totalDiskSpace = rootFilePath.getTotalSpace();
			if (totalDiskSpace == 0) {
				return 0.0;
			}
			long usedDiskSpace = totalDiskSpace - rootFilePath.getFreeSpace();
			return (double) usedDiskSpace / totalDiskSpace * 100;
		}).register(registry);
	}

}
