package com.icomfortableworld.domain.feed.dto;

import java.time.LocalDateTime;

import com.icomfortableworld.common.entity.Timestamped;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedRequestDto extends Timestamped {
	@NotBlank(message = "내용이 없습니다.")
	private String content;
}
