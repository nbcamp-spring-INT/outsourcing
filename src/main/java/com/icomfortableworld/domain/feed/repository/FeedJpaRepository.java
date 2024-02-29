package com.icomfortableworld.domain.feed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.feed.model.FeedModel;

public interface FeedJpaRepository extends JpaRepository<Feed, Long> {
	// @Query("select f from Feed f where f.memberId = ?1")
	// List<FeedModel> findByMemberId(Long toId);
	List<Feed> findAllByMemberId(Long toId);
}
