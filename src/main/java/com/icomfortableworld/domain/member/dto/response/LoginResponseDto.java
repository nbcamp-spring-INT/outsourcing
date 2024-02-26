package com.icomfortableworld.domain.member.dto.response;

import com.icomfortableworld.domain.member.entity.MemberRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDto {
	private String username;
	private MemberRoleEnum memberRoleEnum;
	private String token;
}
