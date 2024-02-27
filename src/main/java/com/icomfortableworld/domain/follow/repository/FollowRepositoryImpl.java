package com.icomfortableworld.domain.follow.repository;

import com.icomfortableworld.domain.follow.entity.Follow;
import com.icomfortableworld.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FollowRepositoryImpl implements FollowRepository {
    private final FollowJpaRepository followJpaRepository;

    @Override
    public Optional<Follow> findById(Long followId) {
        return followJpaRepository.findById(followId);
    }

    @Override
    public boolean existsByToIdAndFromId(Long fromId, Long toId) {
        return followJpaRepository.existsByToIdAndFromId(fromId, toId);
    }

    @Override
    public Follow save(Follow follow) {
        return followJpaRepository.save(follow);
    }
}
