package com.icomfortableworld.domain.member.repository;

import java.util.Optional;

import com.icomfortableworld.domain.member.entity.Member;

public interface MemberRepository {

	Optional<Member> findById(Long memberId);

	Member findByIdOrElseThrow(Long memberId);
}
