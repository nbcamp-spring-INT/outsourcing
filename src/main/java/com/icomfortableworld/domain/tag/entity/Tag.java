package com.icomfortableworld.domain.tag.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tagId;

	@Column(nullable = false)
	private Long feedId;

	@Column(nullable = false)
	private Long tagSetId;

	public Tag(Long feedId, Long tagSetId) {
		this.feedId = feedId;
		this.tagSetId = tagSetId;
	}
}
