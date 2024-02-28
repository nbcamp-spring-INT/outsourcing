package com.icomfortableworld.domain.comment.exception;

import org.springframework.http.HttpStatus;

public class CustomCommentException extends RuntimeException {
	private final HttpStatus status;
	private final String message;

	public CustomCommentException(final CommentErrorCode code) {
		this.status = HttpStatus.BAD_REQUEST;
		this.message = code.getMessage();
	}

	@Override
	public String getMessage() {
		return message;
	}
}
