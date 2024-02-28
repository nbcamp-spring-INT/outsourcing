package com.icomfortableworld.domain.comment.service;

import java.util.List;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;

public interface CommentService {
	void createComment(CommentRequestDto commentRequestDto, Long memberId);

	// READ
	List<CommentResponseDto> readComment(Long feedId, Long memberId);

	// // UPDATE
	// @Transactional
	// CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto,
	// Long memberId);

	// DELETE
	// void deleteComment(CommentRequestDto commentRequestDto, Long memberId);

}
