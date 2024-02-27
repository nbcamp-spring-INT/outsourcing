package com.icomfortableworld.domain.comment.dto;

import com.icomfortableworld.domain.comment.entity.Comment;

import lombok.Getter;

@Getter

public class CommentResponseDto {

	private Long commentId;
	private String comment;
	private String nickname;

	public CommentResponseDto(Comment comment, String nickname) {
		this.commentId = comment.getCommentId();
		this.comment = comment.getContent();
		this.nickname = nickname;
	}

	public CommentResponseDto(Long commentId, String content, Long memberId, Long feedId) {
	}
}
