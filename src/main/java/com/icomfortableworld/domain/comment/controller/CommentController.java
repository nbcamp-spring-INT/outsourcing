package com.icomfortableworld.domain.comment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;
import com.icomfortableworld.domain.comment.service.CommentService;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/version-1/comments")
public class CommentController {

	private final CommentService commentService;

	@PostMapping
	public ResponseEntity<CommentResponseDto> createComment(
		@RequestBody CommentRequestDto commentRequestDto,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {

		return commentService.createComment(commentRequestDto, memberDetails.getMember().getMemberId());
	}

}

