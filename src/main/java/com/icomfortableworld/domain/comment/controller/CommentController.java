package com.icomfortableworld.domain.comment.controller;

import java.security.Principal;
import java.util.List;

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

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;
import com.icomfortableworld.domain.comment.exception.dto.ExceptionDto;
import com.icomfortableworld.domain.comment.service.CommentService;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/version-1/comments")
public class CommentController {
	private final CommentService commentService;

	@PostMapping("")
	public ResponseEntity<CommentResponseDto> createComment(
		@PathVariable Long feedId,
		@RequestBody CommentRequestDto commentRequestDto,
		Principal principal
	) {
		CommentResponseDto createdComment = commentService.createComment(feedId, commentRequestDto,
			principal);
		return ResponseEntity.ok(createdComment);
	}

	@DeleteMapping("/{commentId}")
	public void deleteComment(
		@PathVariable Long commentId,
		Principal principal
	) {
		commentService.deleteComment(commentId, principal);
	}
}


