package com.vaibhav.blog.payloads;

import java.util.Date;

public class ApiResponse {

	private Date timestamp;
	private String message;
	private String details;
	private boolean success;

	public ApiResponse(Date timestamp, String message, String details, boolean success) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.success = success;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public boolean isSuccess() {
		return success;
	}

}
