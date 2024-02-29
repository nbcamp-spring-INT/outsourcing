package com.icomfortableworld.domain.follow.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowModel {
    private Long followId;
    private Long toId;
    private Long fromId;
    private LocalDateTime createdDate;
}
