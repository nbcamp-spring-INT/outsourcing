package com.icomfortableworld.domain.member.dto.response;

import java.util.List;

import com.icomfortableworld.domain.member.entity.MemberRoleEnum;
import com.icomfortableworld.domain.message.entity.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDto {
	private String username;
	private MemberRoleEnum memberRoleEnum;
	private String token;
	List<Message> messageList;
}
