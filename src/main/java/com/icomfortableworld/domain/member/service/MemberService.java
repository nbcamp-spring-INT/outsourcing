package com.icomfortableworld.domain.member.service;

import com.icomfortableworld.domain.member.dto.request.LoginRequestDto;
import com.icomfortableworld.domain.member.dto.request.MemberUpdateRequestDto;
import com.icomfortableworld.domain.member.dto.request.SignupRequestDto;
import com.icomfortableworld.domain.member.dto.response.LoginResponseDto;
import com.icomfortableworld.domain.member.dto.response.MemberResponseDto;
import com.icomfortableworld.domain.member.dto.response.MemberUpdateResponseDto;

public interface MemberService {
	void signup(SignupRequestDto signupRequestDto);

	LoginResponseDto login(LoginRequestDto loginRequestDto);

	String logout(String username);

	MemberResponseDto getMemeber(Long memberId);

	MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto memberUpdateRequestDto);
}
