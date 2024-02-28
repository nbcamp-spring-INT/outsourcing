package com.icomfortableworld.domain.feed.repository;

import java.util.List;
import java.util.Optional;

import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.feed.model.FeedModel;

public interface FeedRepository {
	Feed save(Feed feed);

	FeedModel findByIdOrElseThrow(Long feedId);

	Optional<FeedModel> findById(Long feedId);

	FeedModel update(Long feedId, Long memberId, String content, String memberRole);

	List<FeedModel> findAll();

	List<FeedModel> findAllById(Long feedId);

	void deleteById(Long feedId, Long memberId, String authority);
}
