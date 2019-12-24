package com.example.exception.component;

public class DemoException extends RuntimeException {

	private static final long serialVersionUID = -9185062164416168469L;

	public DemoException() {
		super("演示用异常");
	}
}
