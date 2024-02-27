package com.icomfortableworld.domain.comment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;

public interface CommentService {
	ResponseEntity<CommentResponseDto> createComment(CommentRequestDto commentRequestDto, Long memberId);

	List<Comment> getAllComments();

}
