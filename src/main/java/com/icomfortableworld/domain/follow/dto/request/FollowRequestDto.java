package com.icomfortableworld.domain.follow.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowRequestDto {
    private Long toId;
    private Long fromId;
}
