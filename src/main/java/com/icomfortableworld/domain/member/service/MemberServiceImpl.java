package com.icomfortableworld.domain.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.icomfortableworld.domain.follow.repository.FollowRepository;
import com.icomfortableworld.domain.member.dto.request.LoginRequestDto;
import com.icomfortableworld.domain.member.dto.request.MemberUpdateRequestDto;
import com.icomfortableworld.domain.member.dto.request.SignupRequestDto;
import com.icomfortableworld.domain.member.dto.response.LoginResponseDto;
import com.icomfortableworld.domain.member.dto.response.MemberResponseDto;
import com.icomfortableworld.domain.member.dto.response.MemberUpdateResponseDto;
import com.icomfortableworld.domain.member.dto.response.MessageBoxDto;
import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.domain.member.entity.MemberRoleEnum;
import com.icomfortableworld.domain.member.entity.PasswordHistory;
import com.icomfortableworld.domain.member.exception.CustomMemberException;
import com.icomfortableworld.domain.member.exception.MemberErrorCode;
import com.icomfortableworld.domain.member.model.MemberModel;
import com.icomfortableworld.domain.member.repository.MemberRepository;
import com.icomfortableworld.domain.member.repository.PasswordHistoryRepository;
import com.icomfortableworld.domain.message.entity.Message;
import com.icomfortableworld.domain.message.repository.MessageJpaRepository;
import com.icomfortableworld.jwt.JwtProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final PasswordHistoryRepository passwordHistoryRepository;
	private final PasswordEncoder passwordEncoder;
	private final FollowRepository followRepository;
	private final MessageJpaRepository messageJpaRepository;

	private final JwtProvider jwtProvider;
	@Value("${admin_token}")
	private String adminToken;

	@Override
	public void signup(SignupRequestDto signupRequestDto) {
		String username = signupRequestDto.getUsername();
		String password = passwordEncoder.encode(signupRequestDto.getPassword());

		Optional<MemberModel> checkUsername = memberRepository.findByUsername(username);
		if (checkUsername.isPresent()) {
			throw new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_USERNAME_ALREADY_EXISTS);
		}

		String email = signupRequestDto.getEmail();
		Optional<MemberModel> checkEmail = memberRepository.findByEmail(email);
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

		MemberModel memberModel = memberRepository.save(Member.of(signupRequestDto, password, role));
		passwordHistoryRepository.save(PasswordHistory.of(memberModel.getMemberId(), password));
	}

	@Override
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
		MemberModel memberModel = memberRepository.findByUsernameOrElseThrow(loginRequestDto.getUsername());
		if (!passwordEncoder.matches(loginRequestDto.getPassword(), memberModel.getPassword())) {
			throw new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_PASSWORD_MISMATCH);
		}
		String token = jwtProvider.createToken(memberModel.getUsername(), memberModel.getMemberRoleEnum());
		List<Message> messageList = messageJpaRepository.findByToNameAndIsReadFalse(loginRequestDto.getUsername());
		Map<String, List<String>> massageBox = new HashMap<>();

		for (Message message : messageList) {
			if (massageBox.containsKey(message.getFromName())) {
				massageBox.get(message.getFromName()).add(message.getContent());
			} else {
				massageBox.put(message.getFromName(), new ArrayList<>(List.of(message.getContent())));
			}
			message.readMessage();
		}

		MessageBoxDto messageBoxDto = new MessageBoxDto(memberModel.getUsername(), massageBox);
		return new LoginResponseDto(memberModel.getUsername(), memberModel.getMemberRoleEnum(), token, messageBoxDto);
	}

	@Override
	public String logout(String username) {
		return jwtProvider.createLogoutToken(username);
	}

	@Override
	public MemberResponseDto getMemeber(Long memberId) {
		MemberModel memberModel = memberRepository.findByIdOrElseThrow(memberId);
		Long followerCount = getFollowingCount(memberId);
		return MemberResponseDto.from(memberModel, followerCount);
	}

	@Override
	public List<MemberResponseDto> getMemebers(MemberRoleEnum memberRoleEnum) {
		if (memberRoleEnum == MemberRoleEnum.ADMIN) {
			List<MemberModel> memberModelList = memberRepository.findAll();
			return memberModelList.stream().map(memberModel -> {
				Long followerCount = getFollowingCount(memberModel.getMemberId());
				return MemberResponseDto.from(memberModel, followerCount);
			}).toList();
		} else {
			throw new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_NOT_AUTH);
		}
	}

	@Override
	public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto memberUpdateRequestDto) {
		MemberModel memberModel = memberRepository.findByIdOrElseThrow(memberId);
		if (!passwordEncoder.matches(memberUpdateRequestDto.getPassword(), memberModel.getPassword())) {
			throw new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_PASSWORD_MISMATCH);
		}

		if (passwordEncoder.matches(memberUpdateRequestDto.getNewPassword(), memberModel.getPassword())) {
			throw new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_PASSWORD_MATCH);
		}

		String newNickname = memberUpdateRequestDto.getNickname();
		String newIntroduction = memberUpdateRequestDto.getIntroduction();
		String newPassword = memberUpdateRequestDto.getNewPassword();

		return MemberUpdateResponseDto.from(
			memberRepository.updateMember(memberId, newNickname, newIntroduction, newPassword));
	}

	private Long getFollowingCount(Long memberId) {
		return (long)followRepository.findByFromId(memberId).size();
	}
}
