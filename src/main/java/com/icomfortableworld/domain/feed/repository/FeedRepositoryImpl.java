package com.icomfortableworld.domain.feed.repository;

import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.feed.entity.Feed;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FeedRepositoryImpl implements FeedRepository{
	private final FeedJpaRepository feedJpaRepository;

	@Override
	public void save(Feed feed) {
		feedJpaRepository.save(feed);
	}
}
