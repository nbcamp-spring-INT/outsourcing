package com.icomfortableworld.domain.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomfortableworld.domain.member.entity.PasswordHistory;

public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {

	List<PasswordHistory> findTop3ByMemberIdOrderByCreatedDateDesc(Long memberId);
}
