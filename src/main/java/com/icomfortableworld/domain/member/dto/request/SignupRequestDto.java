package com.icomfortableworld.domain.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
	@NotBlank
	private String username;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String nickname;
	@NotBlank
	private String password;

	private String introduction;

	private boolean admin = false;

	private String adminToken = "";
}
