package com.sparta.spring_basic_assignment.controller;

import com.sparta.spring_basic_assignment.domain.Article;
import com.sparta.spring_basic_assignment.domain.ArticleRepository;
import com.sparta.spring_basic_assignment.domain.ArticleRequestDto;
import com.sparta.spring_basic_assignment.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleRestController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    // 전체 조회
    @GetMapping("/api/articles")
    public List<Article> readArticles() {
        return articleRepository.findAllByOrderByModifiedAtDesc();
    }

    // 글 작성
    @PostMapping("/api/articles")
    public void createArticle(@RequestBody ArticleRequestDto requestDto) {
        Article article = new Article(requestDto);
        articleRepository.save(article);
    }

    // 비밀번호 조회
    @GetMapping("/api/articles/{id}")
    public String readPassword(@PathVariable Long id) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        return article.getPassword();
    }

    // 글 수정
    @PutMapping("/api/articles/{id}")
    public void updateArticle(@PathVariable Long id, @RequestBody ArticleRequestDto requestDto) {
        articleService.update(id, requestDto);
    }

    // 글 삭제
    @DeleteMapping("/api/articles/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }
}
