package com.icomfortableworld.domain.member.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.domain.member.model.MemberModel;
import com.icomfortableworld.global.exception.member.CustomMemberException;
import com.icomfortableworld.global.exception.member.MemberErrorCode;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

	private final MemberJpaRepository jpaRepository;

	@Override
	public Optional<MemberModel> findById(Long memberId) {
		return jpaRepository.findById(memberId).map(Member::toModel);
	}

	@Override
	public MemberModel findByIdOrElseThrow(Long memberId) {
		return findById(memberId).orElseThrow(
			() -> new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_NOT_FOUND)
		);
	}

	@Override
	public Optional<MemberModel> findByUsername(String username) {
		return jpaRepository.findByUsername(username).map(Member::toModel);
	}

	@Override
	public MemberModel findByUsernameOrElseThrow(String username) {
		return findByUsername(username).orElseThrow(
			() -> new CustomMemberException(MemberErrorCode.MEMBER_ERROR_CODE_NOT_FOUND)
		);
	}

	@Override
	public Optional<MemberModel> findByEmail(String email) {
		return jpaRepository.findByEmail(email).map(Member::toModel);
	}

	@Override
	public void save(Member member) {
		jpaRepository.save(member);
	}
}
