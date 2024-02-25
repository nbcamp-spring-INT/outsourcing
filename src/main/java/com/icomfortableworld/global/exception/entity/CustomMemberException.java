package com.icomfortableworld.global.exception.entity;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomMemberException extends Exception {
	private final HttpStatus status;
	private final String message;

	public CustomMemberException(final MemberErrorCode code) {
		this.status = HttpStatus.BAD_REQUEST;
		this.message = code.getMessage();
	}
}
