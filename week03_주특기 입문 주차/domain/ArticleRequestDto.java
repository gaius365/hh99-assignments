package com.sparta.spring_basic_assignment.domain;

import lombok.Getter;

@Getter
public class ArticleRequestDto {

    private String title;
    private String username;
    private String password;
    private String content;
}