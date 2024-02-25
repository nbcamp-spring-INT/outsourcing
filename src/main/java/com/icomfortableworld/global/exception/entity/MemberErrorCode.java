package com.icomfortableworld.global.exception.entity;

import lombok.Getter;

@Getter
public enum MemberErrorCode {
	MEMBER_ERROR_CODE_NOT_FOUND("MEMBER_ERROR_CODE_NOT_FOUND");
	private final String message;

	MemberErrorCode(String message) {
		this.message = message;
	}
}
