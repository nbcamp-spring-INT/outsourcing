package com.icomfortableworld.domain.member.dto.response;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageBoxDto {
	private String toName;
	private Map<String, List<String>> messages;

}
