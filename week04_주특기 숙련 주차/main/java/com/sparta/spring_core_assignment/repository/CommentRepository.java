package com.sparta.spring_core_assignment.repository;

import com.sparta.spring_core_assignment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticleIdOrderByModifiedAtDesc(Long id);
}