package com.icomfortableworld.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.global.exception.jwt.CustomJwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomJwtException.class)
	public ResponseEntity<CommonResponseDto<Void>> customJwtExceptionHandler(CustomJwtException e) {
		return CommonResponseDto.of(HttpStatus.UNAUTHORIZED, e.getMessage(), null);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CommonResponseDto<Void>> methodArgumentNotValidException(
		MethodArgumentNotValidException e) {
		return CommonResponseDto.of(HttpStatus.BAD_REQUEST, e.getMessage(), null);
	}
}