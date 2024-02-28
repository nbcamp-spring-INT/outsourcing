package com.icomfortableworld.global.exception.member;

import lombok.Getter;

@Getter
public enum MemberErrorCode {
	MEMBER_ERROR_CODE_NOT_FOUND("맴버를 찾을 수 없습니다."),
	MEMBER_ERROR_CODE_USERNAME_ALREADY_EXISTS("중복된 username 입니다."),
	MEMBER_ERROR_CODE_EMAIL_ALREADY_EXISTS("중복된 Email 입니다."),
	MEMBER_ERROR_CODE_ADMIN_TOKEN_MISMATCH("관리자 토큰이 불일치 합니다."),
	MEMBER_ERROR_CODE_PASSWORD_MISMATCH("비밀번호가 불일치 합니다."),
	MEMBER_ERROR_CODE_PASSWORD_MATCH("현재 비밀번호와 변경할 비밀번호가 일치합니다."),
	MEMBER_ERROR_CODE_PASSWORD_RECENTLY_USED("변경하려는 비밀번호가 최근 3회 이내에 사용한 비밀번호입니다.");

	private final String message;

	MemberErrorCode(String message) {
		this.message = message;
	}
}
