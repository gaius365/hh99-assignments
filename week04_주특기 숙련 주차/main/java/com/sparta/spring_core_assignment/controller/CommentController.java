package com.sparta.spring_core_assignment.controller;

import com.sparta.spring_core_assignment.dto.CommentDto;
import com.sparta.spring_core_assignment.model.Comment;
import com.sparta.spring_core_assignment.repository.CommentRepository;
import com.sparta.spring_core_assignment.security.UserDetailsImpl;
import com.sparta.spring_core_assignment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    // 댓글 목록 조회
    @GetMapping("/api/comments/{id}") // 게시글 ID 반영
    public List<Comment> readComments(@PathVariable Long id) {
        return commentService.readComments(id);
    }

    // 댓글 작성
    @PostMapping("/api/comments/{id}") // 게시글 ID 반영
    @ResponseBody
    public void createComment(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentDto requestDto) {
        String username = userDetails.getUser().getUsername();
        Comment comment = new Comment(id, username, requestDto);
        commentRepository.save(comment);
    }

    // 댓글 수정
    @PutMapping("/api/comments/{id}") // 댓글 ID 반영
    public void updateComment(@PathVariable Long id, @RequestBody CommentDto requestDto) {
        commentService.updateComment(id, requestDto);
    }

    // 댓글 삭제
    @DeleteMapping("/api/comments/{id}") // 댓글 ID 반영
    public void deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}