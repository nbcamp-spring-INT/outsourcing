package com.icomfortableworld.domain.feed.dto;

import java.time.LocalDateTime;

import com.icomfortableworld.common.entity.Timestamped;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedRequestDto extends Timestamped {


	@NotBlank
	private String content;

	@NotBlank
	private Long likeCount;

	@NotBlank
	private LocalDateTime createdDate;
}
