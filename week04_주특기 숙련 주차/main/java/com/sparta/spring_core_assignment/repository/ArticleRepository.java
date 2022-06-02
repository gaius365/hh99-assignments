package com.sparta.spring_core_assignment.repository;

import com.sparta.spring_core_assignment.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findById(Long id);

    List<Article> findAllByOrderByModifiedAtDesc();
}
