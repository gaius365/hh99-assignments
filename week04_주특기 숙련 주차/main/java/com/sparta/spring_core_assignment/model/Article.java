package com.sparta.spring_core_assignment.model;

import com.sparta.spring_core_assignment.dto.ArticleDto;
import com.sparta.spring_core_assignment.security.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Article extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Article(UserDetailsImpl userDetails, ArticleDto requestDto) {
        this.username = userDetails.getUser().getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void updateArticle(ArticleDto requestDto) {
        this.content = requestDto.getContent();
    }
}
