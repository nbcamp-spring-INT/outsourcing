package com.icomfortableworld.domain.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;
import com.icomfortableworld.domain.comment.service.CommentService;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/version-1/comments")
public class CommentController {
	private final CommentService commentService;

	@PostMapping
	public ResponseEntity<CommonResponseDto<Void>> createComment(

		@RequestBody CommentRequestDto commentRequestDto,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails
	) {
		commentService.createComment(commentRequestDto, memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "작성되었습니다.", null);

	}

	@GetMapping("")
	public ResponseEntity<CommonResponseDto<List<CommentResponseDto>>> readComment(

		@RequestBody CommentRequestDto commentRequestDto,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails
	) {
		List<CommentResponseDto> commentResponseDtos = commentService.readComment(commentRequestDto.getFeedId(),
			memberDetails.getMember().getMemberId());

		return CommonResponseDto.of(HttpStatus.OK, "조회되었습니다.", commentResponseDtos);
	}

	@PatchMapping("/{commentId}")
	public CommentResponseDto updateComment(
		@PathVariable Long commentId,
		@Valid @RequestBody CommentRequestDto commentRequestDto,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {

		commentService.updateComment(commentId, commentRequestDto, memberDetails.getMember().getMemberId());
		return CommonResponseDto.of(HttpStatus.OK, "수정되었습니다.",commentResponseDto)

	}
	// @DeleteMapping("/{commentId}")
	// public deleteComment(
	// 	@PathVariable Long commentId,
	// 	@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
	//
	// 	return commentService.deleteComment(commentId, memberDetails);
	// }

}





