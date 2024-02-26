package com.icomfortableworld.domain.feed.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icomfortableworld.domain.feed.dto.FeedRequestDto;
import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.feed.repository.FeedRepository;
import com.icomfortableworld.domain.member.entity.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FeedServiceImpl implements FeedService{

	private final FeedRepository feedRepository;

	@Override
	public void createFeed(FeedRequestDto requestDto, Long memberId) {
		Feed feed = new Feed(requestDto, memberId);
		feedRepository.save(feed);
	}
}
