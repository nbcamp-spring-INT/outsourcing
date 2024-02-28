package com.icomfortableworld.domain.comment.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CommentErrorCode {

	COMMNET_ERROR_CODE_NOT_FOUND_USER( "사용자를 찾을 수 없습니다."),

	COMMNET_ERROR_CODE_NOT_FOUND_FEED("피드를 찾을 수 없습니다.");

	private final String message;
}
