package com.icomfortableworld.domain.feed.service;

import com.icomfortableworld.domain.feed.dto.requestDto.FeedRequestDto;
import com.icomfortableworld.domain.feed.dto.responseDto.FeedResponseDto;

public interface FeedService {
	void createFeed(FeedRequestDto requestDto, Long memberId);

	FeedResponseDto updateFeed(Long feedId, FeedRequestDto requestDto, Long memberId);
}
