package com.icomfortableworld.global.exception.feed;

import org.springframework.http.HttpStatus;


public class CustomFeedException extends RuntimeException {
	private final HttpStatus status;
	private final String message;

	public CustomFeedException(final FeedErrorCode code) {
		this.status = HttpStatus.BAD_REQUEST;
		this.message = code.getMessage();
	}

	@Override
	public String getMessage() {
		return message;
	}
}
