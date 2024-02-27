package com.icomfortableworld.global.exception.feed;

import lombok.Getter;

@Getter
public enum FeedErrorCode {
	FEED_ERROR_CODE_NOT_FOUND("Feed not found, 피드를 찾을 수 없습니다."),
	FEED_ERROR_CODE_ID_MISMATCH("수정 권한이 없습니다."),
	FEED_ERROR_CODE_SEARCH_NOT_FOUND("검색 결과가 없습니다.");
	private final String message;

	FeedErrorCode(String message) {
		this.message = message;
	}
}
