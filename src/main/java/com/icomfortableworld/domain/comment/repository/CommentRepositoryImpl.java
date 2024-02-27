package com.icomfortableworld.domain.comment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.comment.entity.Comment;
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
	// @Override
	// public Optional<Comment> findById(Long commentId) {
	// 	return commentRepository.findById(commentId);
	// }



	@Override
	public Comment save(Comment comment) {

		return commentJpaRepository.save(comment);
	}

	@Override
	public List<Comment> findAll() {
		return comments;
	}



}






