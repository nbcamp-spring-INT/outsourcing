package com.icomfortableworld.global.exception.member;

import lombok.Getter;

@Getter
public enum MemberErrorCode {
	MEMBER_ERROR_CODE_NOT_FOUND("Member not found, 맴버를 찾을 수 없습니다."),
	MEMBER_ERROR_CODE_USERNAME_ALREADY_EXISTS("username already exists, 중복된 username 입니다."),
	MEMBER_ERROR_CODE_EMAIL_ALREADY_EXISTS("email already exists, 중복된 Email 입니다."),
	MEMBER_ERROR_CODE_ADMIN_TOKEN_MISMATCH("admin token mismatches, 관리자 토큰이 불일치 합니다."),
	MEMBER_ERROR_CODE_PASSWORD_MISMATCH("password mismatches, 비밀번호가 불일치 합니다.");

	private final String message;

	MemberErrorCode(String message) {
		this.message = message;
	}
}
