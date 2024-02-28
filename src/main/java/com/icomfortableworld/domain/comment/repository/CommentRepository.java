package com.icomfortableworld.domain.comment.repository;

import java.util.List;

import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.model.CommentModel;

public interface CommentRepository {
	CommentModel save(Comment comment);

	List<CommentModel> findByFeedId(Long feedId);

	// CommentModel delete(Comment comment);


}
