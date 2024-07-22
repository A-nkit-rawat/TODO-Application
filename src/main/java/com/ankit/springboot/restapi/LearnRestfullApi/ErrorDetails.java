package com.ankit.springboot.restapi.LearnRestfullApi;

import java.time.LocalDate;

public class ErrorDetails {
//timestamp
	private LocalDate timestamp;


	//message
	private String message;
  
//detail
	private String detail;
	
	public ErrorDetails(LocalDate timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetail() {
		return detail;
	}
	
}
