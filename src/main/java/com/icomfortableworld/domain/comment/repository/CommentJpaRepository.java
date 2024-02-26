package com.icomfortableworld.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icomfortableworld.domain.comment.entity.Comment;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {

}
