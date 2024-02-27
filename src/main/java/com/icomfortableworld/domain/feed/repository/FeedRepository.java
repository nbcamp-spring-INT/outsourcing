package com.icomfortableworld.domain.feed.repository;

import java.util.Optional;

import com.icomfortableworld.domain.feed.entity.Feed;

public interface FeedRepository {
	Feed save(Feed feed);

	Optional<Object> findById(Long feedId);
}
