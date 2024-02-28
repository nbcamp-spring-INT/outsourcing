package com.icomfortableworld.domain.comment.repository;

import java.util.List;
import java.util.Optional;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.model.CommentModel;

public interface CommentRepository {
	CommentModel save(Comment comment);

	// CommentModel delete(Comment comment);
	//
	List<CommentModel> findAllByFeedId(Long feedId);

	Optional<Object> findByCommentId(Long commentId);

	void update(Long commentId,CommentRequestDto commentRequestDto);
}
