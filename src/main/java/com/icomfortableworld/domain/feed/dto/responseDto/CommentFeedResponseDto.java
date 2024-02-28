package com.icomfortableworld.domain.feed.dto.responseDto;

import java.util.ArrayList;
import java.util.List;

import com.icomfortableworld.domain.comment.dto.CommentResponseDto;
import com.icomfortableworld.domain.comment.entity.Comment;

import lombok.Getter;

@Getter
public class CommentFeedResponseDto {
	private Long feedId;
	private String nickname;
	private String content;

	private List<String> tagNameList = new ArrayList<>();
	private List<CommentResponseDto> commentList=new ArrayList<>();

	public CommentFeedResponseDto(Long feedId, String nickname, String content,
		List<String> tagList, List<CommentResponseDto> commentList){
		this.feedId=feedId;
		this.nickname=nickname;
		this.content=content;
		tagNameList.addAll(tagList);
		this.commentList.addAll(commentList);
	}
}
