package com.icomfortableworld.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomfortableworld.domain.feed.entity.Feed;

public interface FeedJpaRepository extends JpaRepository<Feed, Long> {
}
