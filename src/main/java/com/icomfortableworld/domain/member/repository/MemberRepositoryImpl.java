package com.icomfortableworld.domain.member.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.global.exception.member.CustomMemberException;
import com.icomfortableworld.global.exception.member.MemberErrorCode;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

	private final MemberJpaRepository jpaRepository;

	@Override
	public Optional<Member> findById(Long memberId) {
		return jpaRepository.findById(memberId);
	}

	@Override
	public Member findByIdOrElseThrow(Long memberId) {
		return findById(memberId).orElseThrow(
			() -> new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_NOT_FOUND)
		);
	}

	@Override
	public Optional<Member> findByUsername(String username) {
		return jpaRepository.findByUsername(username);
	}

	@Override
	public Member findByUsernameOrElseThrow(String username) {
		return findByUsername(username).orElseThrow(
			() -> new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_NOT_FOUND)
		);
	}

	@Override
	public Optional<Member> findByEmail(String email) {
		return jpaRepository.findByEmail(email);
	}

	@Override
	public Member save(Member member) {
		return jpaRepository.save(member);
	}
}
