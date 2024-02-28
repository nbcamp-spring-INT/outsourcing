package com.icomfortableworld.jwt.exception;

import lombok.Getter;

@Getter
public enum JwtErrorCode {
	JWT_ERROR_CODE_SIGNATURE_EXCEPTION("Invalid JWT signature, 유효하지 않는 JWT 서명 입니다."),
	JWT_ERROR_CODE_EXPIRED_EXCEPTION("Expired JWT token, 만료된 JWT token 입니다."),
	JWT_ERROR_CODE_UNSUPPORTED_TOKEN_EXCEPTION("Unsupported JWT token, 지원되지 않는 JWT 토큰 입니다."),
	JWT_ERROR_CODE_INVALID_TOKEN_EXCEPTION("JWT claims is empty, 잘못된 JWT 토큰 입니다.");

	private final String message;

	JwtErrorCode(String message) {
		this.message = message;
	}
}
