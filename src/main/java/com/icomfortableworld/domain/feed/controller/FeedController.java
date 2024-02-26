package com.icomfortableworld.domain.feed.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.feed.dto.FeedRequestDto;
import com.icomfortableworld.domain.feed.service.FeedService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/version-1/feeds")
public class FeedController {
	private final FeedService feedService;

	@PostMapping("")
	public ResponseEntity<CommonResponseDto<Void>> createFeed(@RequestBody FeedRequestDto requestDto,
						@AuthenticationPrincipal UserDetailsImpl userDetails){
		feedService.createFeed(requestDto, userDetails.getMember());
		return CommonResponseDto.of(HttpStatus.OK, "게시글이 작성되었습니다.", null);
	}
}
