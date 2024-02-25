package com.icomfortableworld.domain.member.model;

import lombok.Getter;

public enum MemberRole {

	ADMIN("Admin"), USER("user");

	@Getter
	private final String role;

	MemberRole(String role) {
		this.role = role;
	}
}
