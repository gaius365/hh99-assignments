package com.sparta.spring_core_assignment.dto;

import lombok.Getter;

@Getter
public class CommentDto {
    private Long articleId;
    private String username;
    private String comment;
}
