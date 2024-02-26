package com.icomfortableworld.domain.feed.service;

import org.springframework.security.core.userdetails.User;

import com.icomfortableworld.domain.feed.dto.FeedRequestDto;
import com.icomfortableworld.domain.member.entity.Member;

public interface FeedService {
    void createFeed(FeedRequestDto requestDto, Member member);
}
