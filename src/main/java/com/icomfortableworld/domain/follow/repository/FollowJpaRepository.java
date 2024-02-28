package com.icomfortableworld.domain.follow.repository;

import com.icomfortableworld.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowJpaRepository extends JpaRepository<Follow, Long> {
    boolean existsByToIdAndFromId(Long fromId, Long toId);
}