package com.icomfortableworld.domain.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberUpdateRequestDto {
	private String nickname;
	private String introduction;
	@NotBlank(message = "password는 공백일 수 없습니다.")
	@Pattern(regexp = "^(?=.*[a-z]).+$", message = "비밀번호는 알파벳 소문자가 포함되어야 합니다.")
	@Pattern(regexp = "^(?=.*[A-Z]).+$", message = "비밀번호는 알파벳 대문자가 포함되어야 합니다.")
	@Pattern(regexp = "^(?=.*\\d).+$", message = "비밀번호는 숫자가 포함되어야 합니다.")
	@Pattern(regexp = "^(?=.*[!@#$%^&*(){}]).+$", message = "비밀번호는 특수문자가 포함되어야 합니다.")
	@Size(min = 8, max = 15)
	private String password;
	@NotBlank(message = "password는 공백일 수 없습니다.")
	@Pattern(regexp = "^(?=.*[a-z]).+$", message = "비밀번호는 알파벳 소문자가 포함되어야 합니다.")
	@Pattern(regexp = "^(?=.*[A-Z]).+$", message = "비밀번호는 알파벳 대문자가 포함되어야 합니다.")
	@Pattern(regexp = "^(?=.*\\d).+$", message = "비밀번호는 숫자가 포함되어야 합니다.")
	@Pattern(regexp = "^(?=.*[!@#$%^&*(){}]).+$", message = "비밀번호는 특수문자가 포함되어야 합니다.")
	@Size(min = 8, max = 15)
	private String newPassword;
}
