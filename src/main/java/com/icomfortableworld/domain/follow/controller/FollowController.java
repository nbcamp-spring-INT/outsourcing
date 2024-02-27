package com.icomfortableworld.domain.follow.controller;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.follow.dto.request.FollowRequestDto;
import com.icomfortableworld.domain.follow.service.FollowService;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/version-1/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;
    @PostMapping
    public ResponseEntity<CommonResponseDto<Void>> followMember(
            @Valid @RequestBody FollowRequestDto requestDto,
            @AuthenticationPrincipal MemberDetailsImpl memberDetails) {
        Long toId = memberDetails.getMember().getMemberId();
        followService.followMember(toId, requestDto.getFromId());
        return CommonResponseDto.of(HttpStatus.OK, "팔로우하였습니다.", null);
    }
}

