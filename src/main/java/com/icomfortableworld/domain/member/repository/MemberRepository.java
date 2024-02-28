package com.icomfortableworld.domain.member.repository;

import java.util.Optional;

import com.icomfortableworld.domain.member.entity.Member;
import com.icomfortableworld.domain.member.model.MemberModel;

public interface MemberRepository {

	Optional<MemberModel> findById(Long memberId);

	MemberModel findByIdOrElseThrow(Long memberId);

	Optional<MemberModel> findByUsername(String username);

	MemberModel findByUsernameOrElseThrow(String username);

	Optional<MemberModel> findByEmail(String email);

	MemberModel save(Member member);

	MemberModel updateMember(Long memberId, String newNickname, String newIntroduction, String newPassword);
}
