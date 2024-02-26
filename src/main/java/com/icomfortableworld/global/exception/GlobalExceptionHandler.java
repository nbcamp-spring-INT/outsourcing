package com.icomfortableworld.global.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.common.dto.ErrorResponseDto;
import com.icomfortableworld.global.exception.jwt.CustomJwtException;
import com.icomfortableworld.global.exception.member.CustomMemberException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponseDto<List<String>> methodArgumentNotValidException(
		MethodArgumentNotValidException e) {
		List<String> errorList = new ArrayList<>();
		for(FieldError fieldError : e.getBindingResult().getFieldErrors()){
			errorList.add(fieldError.getDefaultMessage());
		}
		return ErrorResponseDto.of(HttpStatus.BAD_REQUEST, errorList);
	}

	@ExceptionHandler(CustomJwtException.class)
	public ResponseEntity<CommonResponseDto<Void>> customJwtExceptionHandler(CustomJwtException e) {
		return CommonResponseDto.of(HttpStatus.UNAUTHORIZED, e.getMessage(), null);
	}

	@ExceptionHandler(CustomMemberException.class)
	public ResponseEntity<CommonResponseDto<Void>> customMemberExceptionHandler(CustomMemberException e) {
		return CommonResponseDto.of(HttpStatus.BAD_REQUEST, e.getMessage(), null);
	}
}