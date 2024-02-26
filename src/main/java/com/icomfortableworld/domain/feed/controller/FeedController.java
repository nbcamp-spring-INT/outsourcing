package com.icomfortableworld.domain.feed.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.feed.dto.FeedRequestDto;
import com.icomfortableworld.domain.feed.service.FeedService;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/version-1/feeds")
public class FeedController {
	private final FeedService feedService;

	//들어오는 회원이 존재하는지 확인해야 함
	//글 작성할 때 태그도 같이 만들어져야 함
	@PostMapping
	public ResponseEntity<CommonResponseDto<Void>> createFeed(@Valid @RequestBody FeedRequestDto requestDto,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails){
		feedService.createFeed(requestDto, memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "게시글이 작성되었습니다.", null);
	}



}
