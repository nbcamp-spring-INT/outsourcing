package com.icomfortableworld.domain.comment.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.icomfortableworld.domain.comment.exception.dto.ExceptionDto;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler({
		NotFoundMemberException.class,
		NotFoundFeedException.class,
		NotFoundCommentException.class,
	})
	public ResponseEntity<ExceptionDto> handleNotFoundException(Exception e) {
		return ResponseEntity.badRequest()
			.body(new ExceptionDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
	}
}
