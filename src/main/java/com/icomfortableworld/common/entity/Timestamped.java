package com.icomfortableworld.common.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime updatedDate;
	private LocalDateTime deletedDate;
}