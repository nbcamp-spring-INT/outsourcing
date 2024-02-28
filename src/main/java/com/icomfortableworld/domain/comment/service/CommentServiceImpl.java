package com.icomfortableworld.domain.comment.service;

import static com.icomfortableworld.domain.comment.exception.ErrorCode.*;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;
import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.exception.CustomException;
import com.icomfortableworld.domain.comment.repository.CommentRepository;
import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.feed.repository.FeedRepository;
import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.domain.member.repository.MemberRepository;

import jakarta.activation.DataContentHandler;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

	private final MemberRepository memberRepository;
	private final FeedRepository feedRepository;
	private final CommentRepository commentRepository;

	@Override
	public void createComment(CommentRequestDto commentRequestDto, Long memberId) {

		memberRepository.findByIdOrElseThrow(memberId);
		feedRepository.findByIdOrElseThrow(commentRequestDto.getFeedId());
		Comment comment = new Comment(memberId, commentRequestDto.getFeedId(), commentRequestDto.getContent());
		commentRepository.save(comment);

	}

	// @Transactional
	// public void deleteComment(Long memberId, Long commentId, Principal principal) {
	//
	// 	memberRepository.findByIdOrElseThrow(memberId);
	// 	Comment comment = (Comment)commentRepository.findById(commentId)
	// 		.orElseThrow(() -> new CustomException(NOT_FOUND_COMMENT));
	//
	// 	commentRepository.delete(comment);
	// }
}


