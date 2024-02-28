package com.icomfortableworld.domain.follow.service;

import com.icomfortableworld.domain.follow.entity.Follow;
import com.icomfortableworld.domain.follow.repository.FollowRepository;
import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.domain.member.model.MemberModel;
import com.icomfortableworld.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final MemberRepository memberRepository;

    @Override
    public void followMember(Long toId, Long fromId) {

        MemberModel follower = memberRepository.findByIdOrElseThrow(fromId);
        if (followRepository.existsByToIdAndFromId(toId, fromId)) {
            throw new IllegalArgumentException("이미 팔로우한 사용자입니다.");
        }
        Follow follow = new Follow();
        follow.setToId(toId);
        follow.setFromId(fromId);
        follow.setCreatedDate(LocalDateTime.now());
        followRepository.save(follow);
    }
}