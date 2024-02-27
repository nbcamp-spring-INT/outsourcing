package com.icomfortableworld.domain.feed.dto.responseDto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class FeedResponseDto {
	private String content;

	private List<String> tagNameList = new ArrayList<>();

	public FeedResponseDto(String content, List<String> tagList){
		this.content=content;
		tagNameList.addAll(tagList);
	}
}
