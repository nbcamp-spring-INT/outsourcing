package com.icomfortableworld.domain.comment.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.icomfortableworld.common.entity.Timestamped;
import com.icomfortableworld.domain.comment.dto.CommentRequestDto;
import com.icomfortableworld.domain.comment.model.CommentModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Column(nullable = false)
	private Long memberId;

	@Column(nullable = false)
	private Long feedId;

	@Column(nullable = false, length = 40)
	private String content;


	public Comment (Long memberId, Long feedId, String content) {
		this.memberId = memberId;
		this.feedId = feedId;
		this.content = content;
	}

	public Comment(CommentRequestDto commentRequestDto, Long memberId) {
		super();
	}

	public CommentModel toModel() {
		return CommentModel.builder()
			.memberId(memberId)
			.feedId(feedId)
			.content(content)
			.createdDate(this.getCreatedDate())
			.updatedDate(this.getUpdatedDate())
			.deletedDate(this.getDeletedDate())
			.build();
	}
}

