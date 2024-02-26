package com.icomfortableworld.domain.tag.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class TagSet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tagSetId;

	@Column(nullable = false)
	private String tagName;

	public TagSet(String tagName){
		this.tagName=tagName;
	}

}
