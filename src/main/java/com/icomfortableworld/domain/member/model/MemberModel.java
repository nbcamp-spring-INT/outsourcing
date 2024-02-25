package com.icomfortableworld.domain.member.model;

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
	private String identity;
	private String username;
	private String nickname;
	private String password;
	private String introduction;
	private MemberRole memberRole;
}
