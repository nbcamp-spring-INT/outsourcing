package com.icomfortableworld.domain.comment.dto;

import com.icomfortableworld.common.entity.Timestamped;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter

public class CommentRequestDto extends Timestamped {
	@NotBlank
	private String comment;
}
