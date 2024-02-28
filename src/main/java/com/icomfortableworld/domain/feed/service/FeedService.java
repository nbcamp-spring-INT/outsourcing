package com.icomfortableworld.domain.feed.service;

import java.util.List;

import com.icomfortableworld.domain.feed.dto.requestDto.FeedRequestDto;
import com.icomfortableworld.domain.feed.dto.responseDto.CommentFeedResponseDto;
import com.icomfortableworld.domain.feed.dto.responseDto.FeedResponseDto;

public interface FeedService {
	void createFeed(FeedRequestDto requestDto, Long memberId);

	FeedResponseDto updateFeed(Long feedId, FeedRequestDto requestDto, Long memberId, String memberRole);

	List<FeedResponseDto> getAllFeeds(Long memberId);

	CommentFeedResponseDto getFeed(Long feedId,Long memberId);

	List<FeedResponseDto> getSearchResultFeeds(String q, Long memberId);

	void deleteFeed(Long feedId, Long memberId, String authority);
}
