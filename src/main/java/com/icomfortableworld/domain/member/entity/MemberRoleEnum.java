package com.icomfortableworld.domain.member.entity;

public enum MemberRoleEnum {

	USER(Authority.USER),
	ADMIN(Authority.ADMIN);

	private final String authority;

	MemberRoleEnum(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return this.authority;
	}

	private static class Authority {
		public static final String USER = "ROLE_USER";
		public static final String ADMIN = "ROLE_ADMIN";
	}
}
