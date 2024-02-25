package com.icomfortableworld.domain.member.entity;

import com.icomfortableworld.domain.member.model.MemberRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	@Column(nullable = false, length = 10)
	private String identity;
	@Column(nullable = false, length = 20)
	private String username;
	@Column(nullable = false, length = 20)
	private String nickname;
	@Column(nullable = false, length = 15)
	private String password;
	@Column(length = 40)
	private String introduction;
	@Column(nullable = false)
	private MemberRole role;
}