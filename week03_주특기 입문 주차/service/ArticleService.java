package com.sparta.spring_basic_assignment.service;

import com.sparta.spring_basic_assignment.domain.Article;
import com.sparta.spring_basic_assignment.domain.ArticleRepository;
import com.sparta.spring_basic_assignment.domain.ArticleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void update(Long id, ArticleRequestDto requestDto) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 ID가 없습니다.")
        );
        article.update(requestDto);
    }
}
