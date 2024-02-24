package com.icomfortableworld.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomfortableworld.domain.member.entity.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}
