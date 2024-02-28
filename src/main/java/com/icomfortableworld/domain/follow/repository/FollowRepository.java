package com.icomfortableworld.domain.follow.repository;

import com.icomfortableworld.domain.follow.entity.Follow;

import java.util.Optional;

public interface FollowRepository {

    Follow save(Follow follow);

    boolean existsByToIdAndFromId(Long toId, Long fromId);

    Optional<Follow> findByFollowIdAndFromId(Long followId, Long fromId);

    void delete(Follow follow);


}