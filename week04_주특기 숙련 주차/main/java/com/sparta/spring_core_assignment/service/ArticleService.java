package com.sparta.spring_core_assignment.service;

import com.sparta.spring_core_assignment.dto.ArticleDto;
import com.sparta.spring_core_assignment.model.Article;
import com.sparta.spring_core_assignment.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    // 게시글 목록 조회
    public List<Article> readAllArticles() {
        return articleRepository.findAllByOrderByModifiedAtDesc();
    }

    // 게시글 상세 조회
    public Article readArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );
        return article;
    }

    // 게시글 수정
    @Transactional
    public void updateArticle(Long id, ArticleDto requestDto) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다.")
        );
        article.updateArticle(requestDto);
    }
}
