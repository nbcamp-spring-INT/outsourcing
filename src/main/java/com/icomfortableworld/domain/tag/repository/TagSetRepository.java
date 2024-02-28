package com.icomfortableworld.domain.tag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomfortableworld.domain.tag.entity.TagSet;

public interface TagSetRepository extends JpaRepository<TagSet, Long> {
	Optional<TagSet> findByTagName(String tagName);

	TagSet findByTagSetId(Long tagSetId);
}
