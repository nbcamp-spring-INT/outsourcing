package com.icomfortableworld.domain.member.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class PasswordHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passwordHistoryId;
	@Column(nullable = false)
	private Long memberId;
	@Column(nullable = false)
	private String password;
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;

	public static PasswordHistory of(Long memberId, String password) {
		return PasswordHistory.builder()
			.memberId(memberId)
			.password(password)
			.build();
	}
}
