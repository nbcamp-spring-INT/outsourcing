package com.icomfortableworld.domain.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.dto.CommentResponseDto;
import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.model.CommentModel;
import com.icomfortableworld.domain.comment.repository.CommentRepository;
import com.icomfortableworld.domain.feed.model.FeedModel;
import com.icomfortableworld.domain.feed.repository.FeedRepository;
import com.icomfortableworld.domain.member.model.MemberModel;
import com.icomfortableworld.domain.member.repository.MemberRepository;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;
	private final MemberRepository memberRepository;
	private final FeedRepository feedRepository;

	// CREATE
	@Override
	public void createComment(CommentRequestDto commentRequestDto, Long memberId) {

		memberRepository.findByIdOrElseThrow(memberId);
		Comment comment = new Comment(memberId, commentRequestDto.getFeedId(), commentRequestDto.getContent());
		commentRepository.save(comment);


	}

	// READ
	@Override
	public List<CommentResponseDto> readComment(Long feedId, Long memberId) {
		List<CommentModel> commentList = commentRepository.findByFeedId(feedId);
		List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

		for (CommentModel commentModel : commentList) {
			MemberModel memberModel = memberRepository.findByIdOrElseThrow(commentModel.getMemberId());
			FeedModel feedModel = feedRepository.findByIdOrElseThrow(commentModel.getFeedId());
			commentResponseDtos.add(CommentResponseDto.convertToDto(commentModel, memberModel.getNickname()));
		}

		return commentResponseDtos;
	}

	@Override
	public CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto, Long memberId) {
		return null;
	}


	// UPDATE
	public CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto, MemberDetailsImpl memberDetails) {
		Comment comment = (Comment)commentRepository.findByFeedId(commentRequestDto.getFeedId());

		if(!(comment.getMemberId() == memberDetails.getMember().getMemberId())) {
			throw new IllegalArgumentException("등록된 사용자가 아닙니다.");
		}

		comment.update(commentRequestDto);
		return new CommentResponseDto(comment, memberDetails.getMember().getNickname());
	}

	// DELETE
	public void deleteComment(CommentRequestDto commentRequestDto Long memberId) {
		MemberModel memberModel = memberRepository.findByIdOrElseThrow(memberId);

		commentRepository.delete(comment);
	}
}





