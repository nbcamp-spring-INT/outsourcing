package com.icomfortableworld.domain.comment.repository;

import java.util.Optional;

import com.icomfortableworld.domain.comment.entity.Comment;

public class CommentRepositoryImpl implements CommentRepository {
	private final CommentRepository commentRepository;
}

@Override
public Optional<Comment> findById(Long feedId) {
	return feedJpaRepository.findById(feedId);
	@Override
	public Comment save(Comment comment) {
		return CommentJpaRepository.save(comment);
	}
