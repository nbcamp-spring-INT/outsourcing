package com.icomfortableworld.domain.feed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.feed.model.FeedModel;

public interface FeedJpaRepository extends JpaRepository<Feed, Long> {
}
