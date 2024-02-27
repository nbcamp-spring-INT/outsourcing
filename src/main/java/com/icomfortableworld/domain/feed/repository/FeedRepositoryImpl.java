package com.icomfortableworld.domain.feed.repository;

import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.feed.entity.Feed;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FeedRepositoryImpl implements FeedRepository{
	private final FeedJpaRepository feedJpaRepository;

	@Override
	public Feed save(Feed feed) {
		return feedJpaRepository.save(feed);
	}
}
