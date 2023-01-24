package com.masai.exceptionhandler;

import java.time.LocalDateTime;

public class MyErrorDetails {
	private String name;
	private LocalDateTime localDateTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public MyErrorDetails(String name, LocalDateTime localDateTime) {
		super();
		this.name = name;
		this.localDateTime = localDateTime;
	}
	

}
