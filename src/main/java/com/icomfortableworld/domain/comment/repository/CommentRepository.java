package com.icomfortableworld.domain.comment.repository;

import java.util.List;
import java.util.Optional;

import com.icomfortableworld.domain.comment.entity.Comment;

public interface CommentRepository {
	Comment save(Comment comment);

	List<Comment> findAll();

	List<Comment> findAllByfeed_FeedId(Long feedId);

	Optional<Object> findById(Long commentId);

	void delete(Comment comment);

	String getContent(Comment comment);
}
