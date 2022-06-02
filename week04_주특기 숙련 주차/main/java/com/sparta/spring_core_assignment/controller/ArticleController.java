package com.sparta.spring_core_assignment.controller;

import com.sparta.spring_core_assignment.dto.ArticleDto;
import com.sparta.spring_core_assignment.model.Article;
import com.sparta.spring_core_assignment.repository.ArticleRepository;
import com.sparta.spring_core_assignment.security.UserDetailsImpl;
import com.sparta.spring_core_assignment.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    // 게시글 목록 조회
    @GetMapping("/api/articles")
    public List<Article> readAllArticles() {
        return articleService.readAllArticles();
    }

    // 게시글 상세 조회
    @GetMapping("/api/articles/{id}")
    public Article readArticle(@PathVariable Long id) {
        return articleService.readArticle(id);
    }

    // 게시글 작성
    @PostMapping("/api/articles")
    @ResponseBody
    public String createArticle(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody ArticleDto requestDto) {
        Article article = new Article(userDetails, requestDto);
        articleRepository.save(article);
        return "redirect:/";
    }

    // 게시글 수정
    @PutMapping("/api/articles/{id}")
    public void updateArticle(@PathVariable Long id, @RequestBody ArticleDto requestDto) {
        articleService.updateArticle(id, requestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/api/articles/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }

}
