package com.icomfortableworld.domain.comment.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;
import com.icomfortableworld.domain.comment.repository.CommentRepository;
import com.icomfortableworld.domain.feed.repository.FeedRepository;
import com.icomfortableworld.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;
	private final MemberRepository memberRepository;
	private final FeedRepository feedRepository;

	@Override
	public ResponseEntity<CommentResponseDto> createComment(CommentRequestDto commentRequestDto,
		Long memberId) {
		// Member member = memberRepository.findByIdOrElseThrow(memberId);
		// // Feed feed = feedRepository.find
		// Comment saveComment = new Comment(commentRequestDto.getContent(), member.getMemberId(), 1L);
		// commentRepository.save(saveComment);

		return null;
	}
}
