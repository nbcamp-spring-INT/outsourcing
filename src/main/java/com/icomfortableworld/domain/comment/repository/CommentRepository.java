package com.icomfortableworld.domain.comment.repository;

import java.util.List;
import java.util.Optional;

import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.model.CommentModel;

public interface CommentRepository {
	CommentModel save(Comment comment);

	// void delete(Comment comment);
	//
	// List<Comment> findAll();
	//
	// List<Comment> findAllByfeed_FeedId(Long feedId);
	//
	// Optional<Object> findById(Long commentId);
	//
	// String getContent(Comment comment);
	//
	//
	//


	// 함수 원형
}
