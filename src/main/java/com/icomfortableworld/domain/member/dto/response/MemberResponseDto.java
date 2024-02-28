package com.icomfortableworld.domain.member.dto.response;

import com.icomfortableworld.domain.member.entity.MemberRoleEnum;
import com.icomfortableworld.domain.member.model.MemberModel;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {
	private String username;
	private String email;
	private String nickname;
	private String introduction;
	private MemberRoleEnum memberRoleEnum;
	private Long followerCount;

	public static MemberResponseDto from(MemberModel memberModel, Long followerCount) {
		return MemberResponseDto.builder()
			.username(memberModel.getUsername())
			.email(memberModel.getEmail())
			.nickname(memberModel.getNickname())
			.introduction(memberModel.getIntroduction())
			.followerCount(followerCount)
			.memberRoleEnum(memberModel.getMemberRoleEnum())
			.build();
	}
}
