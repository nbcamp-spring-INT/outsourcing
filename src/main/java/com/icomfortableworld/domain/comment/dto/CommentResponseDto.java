package com.icomfortableworld.domain.comment.dto;

import com.icomfortableworld.domain.comment.entity.Comment;

import lombok.Getter;

@Getter
public class CommentResponseDto {
	private Long commentId;
	private String comment;
	private String feedId;

	public CommentResponseDto(Comment comment, Long feedId) {
		this.commentId = comment.getCommentId();
		this.comment = comment.getContents();
		this.feedId = feedId;
	}
}
