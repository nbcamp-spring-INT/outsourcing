package com.icomfortableworld.domain.comment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.service.CommentService;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

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

	// @GetMapping("")
	// public ResponseEntity<CommonResponseDto<List<CommonResponseDto>>> readComment(@Pathvariable Long feedId) {
	// 	List<CommentResponseDto> comments = commentService.readComment(feedId);
	// 	return CommonResponseDto.of(HttpStatus.OK,"조회되었습니다.",comments)
	// }

}

// @DeleteMapping("/{commentId}")
// public void deleteComment(
// 	@PathVariable Long commentId,
// 	@AuthenticationPrincipal MemberDetailsImpl memberDetails
// ) {
// 	commentService.deleteComment(commentId);
// }



