package com.icomfortableworld.domain.feed.service;

import com.icomfortableworld.domain.feed.dto.FeedRequestDto;

public interface FeedService {
    void createFeed(FeedRequestDto requestDto, Long memberId);
}
