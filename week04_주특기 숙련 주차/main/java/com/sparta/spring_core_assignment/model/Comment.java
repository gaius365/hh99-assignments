package com.sparta.spring_core_assignment.model;

import com.sparta.spring_core_assignment.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long articleId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    public Comment(Long id, String username, CommentDto requestDto) {
        this.articleId = id;
        this.username = username;
        this.comment = requestDto.getComment();
    }

    public void updateComment(CommentDto requestDto) {
        this.comment = requestDto.getComment();
    }
}