package com.sparta.spring_basic_assignment.domain;

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
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;

    public Article(ArticleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    public void update(ArticleRequestDto requestDto) {
        this.content = requestDto.getContent();
    }
}