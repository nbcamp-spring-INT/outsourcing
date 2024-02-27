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
public class CommentServiceImpl implements CommentService {

	private final MemberRepository memberRepository;
	private final FeedRepository feedRepository;
	private final CommentRepository commentRepository;

	@Transactional
	public CommentResponseDto createComment(Long memberId,Long feedId, CommentRequestDto commentRequestDto,
		Principal principal) {

		Member member = (Member)memberRepository.findById(memberId)
			.orElseThrow(() -> new CustomException(NOT_FOUND_USER));

		Feed feed = (Feed)feedRepository.findById(feedId)
			.orElseThrow(() -> new CustomException(NOT_FOUND_FEED));

		Comment comment = Comment.builder()
			.member(member)
			.feed(feed)
			.content(commentRequestDto.getContent())
			.build();

		Comment savedComment = commentRepository.save(comment);

		return CommentResponseDto.convertToDto(savedComment);
	}

	@Transactional
	public void deleteComment(Long memberId, Long commentId, Principal principal) {

		Member member = memberRepository.findById(memberId)
			.orElseThrow(() -> new CustomException(NOT_FOUND_USER));

		Comment comment = (Comment)commentRepository.findById(commentId)
			.orElseThrow(() -> new CustomException(NOT_FOUND_COMMENT));

		commentRepository.delete(comment);
	}

	@Override
	public ResponseEntity<CommentResponseDto> createComment(CommentRequestDto commentRequestDto, Long memberId) {
		return null;
	}
}


