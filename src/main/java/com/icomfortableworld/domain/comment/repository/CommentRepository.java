package com.icomfortableworld.domain.comment.repository;

import java.util.List;
import java.util.Optional;

import com.icomfortableworld.domain.comment.dto.CommentRequestUpdateDto;
import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.model.CommentModel;

public interface CommentRepository {
	CommentModel save(Comment comment);

	List<CommentModel> findByFeedId(Long feedId);

	// CommentModel delete(Comment comment);

	CommentModel findByIdOrElseThrow(Long commentId);

	CommentModel update(Long commentId, CommentRequestUpdateDto commentRequestUpdateDto);

	Optional<CommentModel> findById(Long commentId);

	void deleteByFeedId (Long feedId);
}
