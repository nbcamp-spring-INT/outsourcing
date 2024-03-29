package com.icomfortableworld.domain.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icomfortableworld.domain.tag.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	List<Tag> findAllByFeedId(Long feedId);

	Tag findByTagSetId(Long tagSetId);

	List<Tag> findAllByTagSetId(Long tagSetId);
}
