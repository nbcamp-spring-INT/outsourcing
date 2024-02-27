package com.icomfortableworld.domain.comment.repository;

import java.util.List;

import com.icomfortableworld.domain.comment.entity.Comment;

public interface CommentRepository {
	Comment save(Comment comment);

	List<Comment> findAll();
}
