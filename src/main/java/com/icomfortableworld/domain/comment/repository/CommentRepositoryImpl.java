package com.icomfortableworld.domain.comment.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.model.CommentModel;
import com.icomfortableworld.domain.feed.repository.FeedRepository;
import com.icomfortableworld.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class CommentRepositoryImpl implements CommentRepository {
	private final CommentJpaRepository commentJpaRepository;
	private final FeedRepository feedRepository;
	private final MemberRepository memberRepository;
	private List<Comment> comments = new ArrayList<>();

	@Override
	public CommentModel save(Comment comment) {

		return commentJpaRepository.save(comment).toModel();
	}

	// @Override
	// public CommentModel delete(Comment comment) {
	// 	return null;
	// }

	@Override
	public List<Comment> findAllByFeedId(Long feedId) {
		return null;
	}

	@Override
	public Optional<Object> findByCommentId(Long commentId) {
		return Optional.empty();
	}
}






