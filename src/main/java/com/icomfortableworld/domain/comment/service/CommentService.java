package com.icomfortableworld.domain.comment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;
import com.icomfortableworld.domain.comment.exception.dto.ExceptionDto;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

public interface CommentService {
	ResponseEntity<CommentResponseDto> createComment(CommentRequestDto commentRequestDto, Long memberId);

}
