package com.icomfortableworld.domain.comment.dto;

import com.icomfortableworld.common.entity.Timestamped;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentRequestDto {

	@NotBlank
	private String content;
	private Long feedId;
}
