package com.gokul.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timeStamp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.timeStamp = localDateTime;
		this.message = message;
		this.details = details;
	}
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
}
