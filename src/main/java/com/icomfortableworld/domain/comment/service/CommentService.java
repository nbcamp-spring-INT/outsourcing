package com.icomfortableworld.domain.comment.service;

import org.springframework.http.ResponseEntity;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;

public interface CommentService {
	ResponseEntity<CommentResponseDto> createComment(CommentRequestDto commentRequestDto, Long memberId);
}
