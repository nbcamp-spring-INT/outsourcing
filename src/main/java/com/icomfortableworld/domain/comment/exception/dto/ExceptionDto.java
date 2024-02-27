package com.icomfortableworld.domain.comment.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //null은 json으로 parsing 하지 않음!
public class ExceptionDto {

	private String msg;
	private Integer statusCode;
}
