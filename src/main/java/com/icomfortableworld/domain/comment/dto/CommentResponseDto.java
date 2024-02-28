package com.icomfortableworld.domain.comment.dto;

import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.model.CommentModel;

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
	private String nickname;
	private Long commentId;

	public static CommentResponseDto convertToDto(CommentModel commentmodel,String nickname) {
		return CommentResponseDto.builder()
			.content(commentmodel.getContent())
			.nickname(nickname)
			.commentId(commentmodel.getCommentId())
			.build();
	}
}
