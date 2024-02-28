package com.icomfortableworld.domain.feed.dto.responseDto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

//좋아요 개수 필요
@Getter
public class FeedResponseDto {
	private Long feedId;
	private String nickname;
	private String content;

	private List<String> tagNameList = new ArrayList<>();

	public FeedResponseDto(String content, List<String> tagList){
		this.content=content;
		tagNameList.addAll(tagList);
	}
	public  FeedResponseDto(Long feedId, String nickname, String content, List<String> tagList){
		this.feedId=feedId;
		this.nickname=nickname;
		this.content=content;
		tagNameList.addAll(tagList);
	}
}
