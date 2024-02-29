package com.icomfortableworld.domain.member.model;

import java.time.LocalDateTime;

import com.icomfortableworld.domain.member.entity.MemberRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberModel {
	private Long memberId;
	private String username;
	private String email;
	private String nickname;
	private String password;
	private String introduction;
	private MemberRoleEnum memberRoleEnum;
	private LocalDateTime createdDate;

}
