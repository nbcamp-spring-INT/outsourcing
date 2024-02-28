package com.icomfortableworld.domain.follow.service;


public interface FollowService {
    void followMember(Long fromId, Long toId);
    void unfollowMember(Long followId, Long fromId);
}
