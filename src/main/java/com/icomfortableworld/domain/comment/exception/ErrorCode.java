package com.icomfortableworld.domain.comment.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

	// 사용자
	NOT_FOUND_USER(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),

	// 피드
	NOT_FOUND_FEED(HttpStatus.NOT_FOUND, "피드를 찾을 수 없습니다."),

	// 댓글
	NOT_FOUND_COMMENT(HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String detail;
}

