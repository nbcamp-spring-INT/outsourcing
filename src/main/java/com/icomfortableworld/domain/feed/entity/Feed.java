package com.icomfortableworld.domain.feed.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.icomfortableworld.common.entity.Timestamped;
import com.icomfortableworld.domain.feed.dto.requestDto.FeedRequestDto;
import com.icomfortableworld.domain.feed.model.FeedModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@SQLDelete(sql = "update feed set deleted_date = NOW() where id=?")
@SQLRestriction(value = "deleted_date is NULL")
@NoArgsConstructor
@AllArgsConstructor
public class Feed extends Timestamped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedId;

	@Column(nullable = false)
	private Long memberId;

	@Column(nullable = false, length = 140)
	private String content;

	@Column(nullable = false)
	private Long likeCount;

	public Feed(FeedRequestDto requestDto, Long memberId) {
		this.content = requestDto.getContent();
		this.likeCount = 0L;
		this.memberId = memberId;
	}

	public FeedModel toModel() {
		return FeedModel.builder()
			.feedId(feedId)
			.memberId(memberId)
			.content(content)
			.likeCount(likeCount)
			.createdDate(this.getCreatedDate())
			.updatedDate(this.getUpdatedDate())
			.deletedDate(this.getDeletedDate())
			.build();
	}

	public void update(String content) {
		this.content = content;
	}
}
