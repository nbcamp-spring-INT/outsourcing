package com.icomfortableworld.domain.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.member.dto.request.LoginRequestDto;
import com.icomfortableworld.domain.member.dto.request.MemberUpdateRequestDto;
import com.icomfortableworld.domain.member.dto.request.SignupRequestDto;
import com.icomfortableworld.domain.member.dto.response.LoginResponseDto;
import com.icomfortableworld.domain.member.dto.response.MemberResponseDto;
import com.icomfortableworld.domain.member.dto.response.MemberUpdateResponseDto;
import com.icomfortableworld.domain.member.service.MemberService;
import com.icomfortableworld.jwt.JwtProvider;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/version-1/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<CommonResponseDto<Void>> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
		memberService.signup(signupRequestDto);
		return CommonResponseDto.of(HttpStatus.OK, "회원가입 성공", null);
	}

	@PostMapping("/login")
	public ResponseEntity<CommonResponseDto<Void>> login(@Valid @RequestBody LoginRequestDto loginRequestDto,
		HttpServletResponse response) {
		LoginResponseDto loginResponseDto = memberService.login(loginRequestDto);
		response.addHeader(JwtProvider.AUTHORIZATION_HEADER, loginResponseDto.getToken());
		return CommonResponseDto.of(HttpStatus.OK, "로그인 성공", null);
	}

	@PostMapping("/logout")
	public ResponseEntity<CommonResponseDto<Void>> logout(HttpServletResponse response,
		@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
		String logoutToken = memberService.logout(memberDetails.getUsername());
		response.addHeader(JwtProvider.AUTHORIZATION_HEADER, logoutToken);
		return CommonResponseDto.of(HttpStatus.OK, "로그아웃 성공", null);
	}

	@GetMapping("/{memberId}")
	public ResponseEntity<CommonResponseDto<MemberResponseDto>> getMember(@PathVariable("memberId") Long memberId) {
		return CommonResponseDto.of(HttpStatus.OK, "회원 정보조회 성공", memberService.getMemeber(memberId));
	}

	@PutMapping("{memberId}")
	public ResponseEntity<CommonResponseDto<MemberUpdateResponseDto>> updateMember(@PathVariable Long memberId,
		@RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
		return CommonResponseDto.of(HttpStatus.OK, "회원 정보수정 성공",
			memberService.updateMember(memberId, memberUpdateRequestDto));
	}
}
