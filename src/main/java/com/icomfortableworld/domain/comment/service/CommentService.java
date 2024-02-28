package com.icomfortableworld.domain.comment.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;



@Transactional
public interface CommentService {
	// CREATE
	void createComment(CommentRequestDto commentRequestDto, Long memberId);

	// READ
	@Transactional(readOnly = true)
	List<CommentResponseDto> readComment(Long feedId, Long memberId);

	// UPDATE
	//
	// CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto,
	// Long memberId);

	//DELETE
	// void deleteComment(CommentRequestDto commentRequestDto, Long memberId);

}
