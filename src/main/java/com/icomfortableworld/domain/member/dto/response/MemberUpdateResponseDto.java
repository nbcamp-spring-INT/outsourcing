package com.icomfortableworld.domain.member.dto.response;

import com.icomfortableworld.domain.member.model.MemberModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MemberUpdateResponseDto {
	private String nickname;
	private String introduction;
	private String password;

	public static MemberUpdateResponseDto from(MemberModel memberModel) {
		return MemberUpdateResponseDto.builder()
			.nickname(memberModel.getNickname())
			.introduction(memberModel.getIntroduction())
			.password(memberModel.getPassword())
			.build();
	}
}
