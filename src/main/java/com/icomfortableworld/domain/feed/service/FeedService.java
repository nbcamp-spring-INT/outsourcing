package com.icomfortableworld.domain.feed.service;

import java.util.List;

import com.icomfortableworld.domain.feed.dto.requestDto.FeedRequestDto;
import com.icomfortableworld.domain.feed.dto.responseDto.FeedResponseDto;

public interface FeedService {
	void createFeed(FeedRequestDto requestDto, Long memberId);

	FeedResponseDto updateFeed(Long feedId, FeedRequestDto requestDto, Long memberId);

	List<FeedResponseDto> getAllFeeds(Long memberId);

	FeedResponseDto getFeed(Long feedId,Long memberId);

	List<FeedResponseDto> getSearchResultFeeds(String q, Long memberId);
}
