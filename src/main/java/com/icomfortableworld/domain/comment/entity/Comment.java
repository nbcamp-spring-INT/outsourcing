package com.icomfortableworld.domain.comment.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.icomfortableworld.common.entity.Timestamped;
import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.feed.entity.Feed;
import com.icomfortableworld.domain.member.entity.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql="update comment set deleted date = NOW() where id=?")
@SQLRestriction(value = "deleted_date is NULL")
@Table(name = "comments")
public class Comment extends Timestamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;

	@Column(nullable = false, length = 40)
	private String content;

	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "feedId")
	private Feed feed;

	public Comment(String content, Member member, Feed feed) {
		this.content = content;
		this.member = member;
		this.feed = feed;
	}

	public void update(CommentRequestDto commentRequestDto) {
		this.content = commentRequestDto.getComment();
	}
}

