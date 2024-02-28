package com.icomfortableworld.domain.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomfortableworld.domain.comment.entity.Comment;
import com.icomfortableworld.domain.comment.model.CommentModel;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {

	List<CommentModel> findByFeedId(Long feedId);
}
