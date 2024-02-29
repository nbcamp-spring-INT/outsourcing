package com.icomfortableworld.domain.member.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomMemberException extends RuntimeException {
	private final HttpStatus status;
	private final String message;

	public CustomMemberException(final MemberErrorCode code) {
		this.status = HttpStatus.BAD_REQUEST;
		this.message = code.getMessage();
	}

	@Override
	public String getMessage() {
		return message;
	}
}
