package com.icomfortableworld.domain.feed.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.feed.dto.requestDto.FeedRequestDto;
import com.icomfortableworld.domain.feed.dto.responseDto.FeedResponseDto;
import com.icomfortableworld.domain.feed.service.FeedService;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/version-1/feeds")
public class FeedController {
	private final FeedService feedService;

	@PostMapping
	public ResponseEntity<CommonResponseDto<Void>> createFeed(@Valid @RequestBody FeedRequestDto requestDto,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
		System.out.println("ghlghglghl" + memberDetails.getMember().getMemberId());
		feedService.createFeed(requestDto, memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "게시글이 작성되었습니다.", null);
	}

	@PutMapping("/{feedId}")
	public ResponseEntity<CommonResponseDto<FeedResponseDto>> updateFeed(@Valid @PathVariable Long feedId,
		@RequestBody FeedRequestDto requestDto,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
		FeedResponseDto responseDto = feedService.updateFeed(feedId, requestDto,
			memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "게시글이 수정되었습니다.", responseDto);
	}

	@GetMapping
	public ResponseEntity<CommonResponseDto<List<FeedResponseDto>>> getAllFeeds(
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
		List<FeedResponseDto> responseDto = feedService.getAllFeeds(memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "전체 게시글을 조회하였습니다.", responseDto);
	}

	//단건조회 = 댓글도 조회해야 함!
	@GetMapping("/{feedId}")
	public ResponseEntity<CommonResponseDto<FeedResponseDto>> getFeed(@PathVariable Long feedId,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
		FeedResponseDto responseDto = feedService.getFeed(feedId, memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "게시글을 조회하였습니다.", responseDto);
	}
}
