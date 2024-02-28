package com.icomfortableworld.domain.follow.repository;

import com.icomfortableworld.domain.follow.entity.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FollowRepositoryImpl implements FollowRepository {
    private final FollowJpaRepository followJpaRepository;

    @Override
    public Optional<Follow> findByFollowIdAndFromId(Long followId, Long fromId) {
        return followJpaRepository.findByFollowIdAndFromId(followId, fromId);
    }


    @Override
    public boolean existsByToIdAndFromId(Long fromId, Long toId) {
        return followJpaRepository.existsByToIdAndFromId(fromId, toId);
    }

    @Override
    public Follow save(Follow follow) {
        return followJpaRepository.save(follow);
    }

    @Override
    public void delete(Follow follow) {
        followJpaRepository.delete(follow);
    }

}