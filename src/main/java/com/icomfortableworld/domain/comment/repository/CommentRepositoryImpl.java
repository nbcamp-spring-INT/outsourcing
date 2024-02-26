package com.icomfortableworld.domain.comment.repository;

import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.comment.entity.Comment;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class CommentRepositoryImpl implements CommentRepository {
	private final CommentJpaRepository commentJpaRepository;

	// @Override
	// public Optional<Comment> findById(Long commentId) {
	// 	return commentRepository.findById(commentId);
	// }

	@Override
	public Comment save(Comment comment) {
		return commentJpaRepository.save(comment);
	}
}


