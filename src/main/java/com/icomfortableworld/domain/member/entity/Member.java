package com.icomfortableworld.domain.member.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.icomfortableworld.common.entity.Timestamped;
import com.icomfortableworld.domain.member.model.MemberModel;
import com.icomfortableworld.domain.member.model.MemberRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@SQLDelete(sql = "update member set deleted_date = NOW() where id = ?")
@SQLRestriction(value = "deleted_date is NULL")
@NoArgsConstructor
@AllArgsConstructor
public class Member extends Timestamped {

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
	@Column(nullable = false, length = 10)
	@Enumerated(value = EnumType.STRING)
	private MemberRole memberRole;

	public MemberModel toModel() {
		return MemberModel.builder()
			.memberId(memberId)
			.identity(identity)
			.username(username)
			.nickname(nickname)
			.password(password)
			.introduction(introduction)
			.memberRole(memberRole)
			.build();
	}
}