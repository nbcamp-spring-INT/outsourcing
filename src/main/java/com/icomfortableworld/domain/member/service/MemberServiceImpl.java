package com.icomfortableworld.domain.member.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icomfortableworld.domain.member.dto.request.SignupRequestDto;
import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.domain.member.entity.MemberRoleEnum;
import com.icomfortableworld.domain.member.repository.MemberRepository;
import com.icomfortableworld.global.exception.member.CustomMemberException;
import com.icomfortableworld.global.exception.member.MemberErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	@Value("${admin_token}")
	private String adminToken;

	@Override
	public void signup(SignupRequestDto signupRequestDto) {
		String username = signupRequestDto.getUsername();
		String password = passwordEncoder.encode(signupRequestDto.getPassword());

		Optional<Member> checkUsername = memberRepository.findByUsername(username);
		if (checkUsername.isPresent()) {
			throw new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_USERNAME_ALREADY_EXISTS);
		}

		String email = signupRequestDto.getEmail();
		Optional<Member> checkEmail = memberRepository.findByEmail(email);
		if (checkEmail.isPresent()) {
			throw new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_EMAIL_ALREADY_EXISTS);
		}

		MemberRoleEnum role = MemberRoleEnum.USER;
		if (signupRequestDto.isAdmin()) {
			if (!adminToken.equals(signupRequestDto.getAdminToken())) {
				throw new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_ADMIN_TOKEN_MISMATCH);
			}
			role = MemberRoleEnum.ADMIN;
		}

		Member member = Member.of(signupRequestDto, password, role);
		memberRepository.save(member);
	}

}
