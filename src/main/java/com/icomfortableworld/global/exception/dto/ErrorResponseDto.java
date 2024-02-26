package com.icomfortableworld.global.exception.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseDto<T> {

	private HttpStatus status;
	private T message;

	public static <T> ErrorResponseDto<T> of(HttpStatus status, T message) {
		return new ErrorResponseDto<>(status, message);
	}
}
