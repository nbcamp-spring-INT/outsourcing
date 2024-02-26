package com.icomfortableworld.domain.comment.model;

import java.time.LocalDateTime;

public class CommentModel {
	private Long commentId;
	private Long feedId;
	private Long memberId;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private LocalDateTime deletedDate;
}

