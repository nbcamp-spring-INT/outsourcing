package com.icomfortableworld.domain.comment.repository;

import com.icomfortableworld.domain.comment.entity.Comment;

public interface CommentRepository {
	Comment save(Comment comment);
}
