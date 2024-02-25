package com.icomfortableworld.global.exception.member;

import lombok.Getter;

@Getter
public enum MemberErrorCode {
	MEMBER_ERROR_CODE_NOT_FOUND("Member not found, 맴버를 찾을 수 없습니다.");

	private final String message;

	MemberErrorCode(String message) {
		this.message = message;
	}
}
