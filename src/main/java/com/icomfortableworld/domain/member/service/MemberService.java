package com.icomfortableworld.domain.member.service;

import com.icomfortableworld.domain.member.dto.request.SignupRequestDto;

public interface MemberService {
	void signup(SignupRequestDto signupRequestDto);
}
