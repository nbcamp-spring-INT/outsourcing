package com.icomfortableworld.domain.comment.dto;

import com.icomfortableworld.domain.comment.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {

	private String content;

	public static CommentResponseDto convertToDto(Comment comment) {
		return CommentResponseDto.builder()
			.content(comment.getContent())
			.build();
	}
}
