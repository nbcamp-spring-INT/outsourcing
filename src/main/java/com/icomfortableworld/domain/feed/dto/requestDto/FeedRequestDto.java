package com.icomfortableworld.domain.feed.dto.requestDto;

import java.time.LocalDateTime;
import java.util.List;

import com.icomfortableworld.common.entity.Timestamped;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedRequestDto{
	@NotBlank(message = "내용이 없습니다.")
	private String content;

	private List<String> tagNameList;
}
