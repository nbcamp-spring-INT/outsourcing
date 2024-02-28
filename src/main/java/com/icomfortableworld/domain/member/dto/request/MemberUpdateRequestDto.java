package com.icomfortableworld.domain.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberUpdateRequestDto {
	private String nickname;
	private String introduction;
	private String password;
	private String newPassword;
}
