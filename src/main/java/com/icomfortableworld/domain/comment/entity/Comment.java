package com.icomfortableworld.domain.comment.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.icomfortableworld.common.entity.Timestamped;
import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@SQLDelete(sql = "update comment set deleted date = NOW() where id=?")
@SQLRestriction(value = "deleted_date is NULL")
@Table(name = "comment")
public class Comment extends Timestamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;

	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "feedId")
	private Feed feed;

	@Column(nullable = false, length = 40)
	private String content;

}

