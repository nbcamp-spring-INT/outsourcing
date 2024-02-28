package com.icomfortableworld.domain.feed.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.feed.dto.requestDto.FeedRequestDto;
import com.icomfortableworld.domain.feed.dto.responseDto.CommentFeedResponseDto;
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
		feedService.createFeed(requestDto, memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "피드 작성 성공", null);
	}

	//관리자도 수정 가능
	@PutMapping("/{feedId}")
	public ResponseEntity<CommonResponseDto<FeedResponseDto>> updateFeed(@Valid @PathVariable Long feedId,
		@RequestBody FeedRequestDto requestDto,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
		FeedResponseDto responseDto = feedService.updateFeed(feedId, requestDto,
			memberDetails.getMember().getMemberId(), memberDetails.getMember().getMemberRoleEnum().getAuthority());
		return CommonResponseDto.of(HttpStatus.OK, "피드 수정 성공", responseDto);
	}

	//관리자 -> 전체조회, 일반 -> 팔로우한 사람만 조회
	@GetMapping
	public ResponseEntity<CommonResponseDto<List<FeedResponseDto>>> getAllFeeds(
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
		List<FeedResponseDto> responseDto = feedService.getAllFeeds(memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "전체 피드 조회 성공", responseDto);
	}

	@GetMapping("/{feedId}")
	public ResponseEntity<CommonResponseDto<CommentFeedResponseDto>> getFeed(@PathVariable Long feedId,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
		CommentFeedResponseDto responseDto = feedService.getFeed(feedId, memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "피드 조회 성공", responseDto);
	}

	@GetMapping("/search")
	public ResponseEntity<CommonResponseDto<List<FeedResponseDto>>> getSearchResultFeeds(@RequestParam String q,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails){
		List<FeedResponseDto> responseDto = feedService.getSearchResultFeeds(q, memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, 	q+"에 대한 검색 결과", responseDto);
	}

	//관리자도 삭제 가능
	@DeleteMapping("/{feedId}")
	public ResponseEntity<CommonResponseDto<Void>> deleteFeed(@PathVariable Long feedId,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails){
		feedService.deleteFeed(feedId, memberDetails.getMember().getMemberId(), memberDetails.getMember().getMemberRoleEnum().getAuthority());
		return CommonResponseDto.of(HttpStatus.OK, "피드 삭제 성공", null);
	}
}
