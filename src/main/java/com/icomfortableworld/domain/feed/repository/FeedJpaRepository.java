package com.icomfortableworld.domain.feed.repository;

import com.icomfortableworld.domain.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedJpaRepository extends JpaRepository<Long, Feed> {
}
