package com.icomfortableworld.domain.follow.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnfollowRequestDto {
    @NotNull(message = "FollowId는 필수입니다.")
    private Long followId;
}