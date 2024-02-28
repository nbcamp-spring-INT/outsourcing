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
		CommentModel commentModel = commentRepository.save(new Comment(commentRequestDto, memberId));
		Comment saveComment = new Comment(memberId, commentRequestDto.getFeedId(), commentRequestDto.getContent());
		commentRepository.save(saveComment);

	}

	// READ
	@Override
	public List<CommentResponseDto> readComment(Long feedId,Long memberId) {
		List<CommentModel> commentList = commentRepository.findAllByFeedId(feedId);
		List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

		for (CommentModel commentModel : commentList) {
			MemberModel memberModel = memberRepository.findByIdOrElseThrow(commentModel.getMemberId());
			FeedModel feedModel = feedRepository.findByIdOrElseThrow(commentModel.getFeedId());
			commentResponseDtos.add(CommentResponseDto.convertToDto(commentModel, memberModel.getNickname()));
		}

		return commentResponseDtos;
	}

	// UPDATE
	// @Transactional
	// @Override
	// public CommentResponseDto updateComment(Long commentId,CommentRequestDto commentRequestDto, Long memberId) {
	// 	MemberModel memberModel = memberRepository.findByIdOrElseThrow(memberDetails.getMemberId());
	// 	FeedModel feedModel = feedRepository.findByIdOrElseThrow(commentModel.getFeedId());
	//
	// 	commentRepository.update(commentId,commentRequestDto);
	//
	// 	return new CommentResponseDto(comment, comment.getMember().getNickname());
	//
	// }

	// DELETE
	// public void deleteComment(CommentRequestDto commentRequestDto, Long memberId) {
	//
	// 	MemberModel memberModel = memberRepository.findByIdOrElseThrow(memberId);
	// 	FeedModel feedModel = feedRepository.findByIdOrElseThrow(commentRequestDto.getFeedId());
	//
	//
	// 	commentRepository.delete(comment);

	}


