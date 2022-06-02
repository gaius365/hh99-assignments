package com.sparta.spring_core_assignment.service;

import com.sparta.spring_core_assignment.dto.CommentDto;
import com.sparta.spring_core_assignment.model.Comment;
import com.sparta.spring_core_assignment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> readComments(Long id) {
        List<Comment> comments = commentRepository.findAllByArticleIdOrderByModifiedAtDesc(id);
        return comments;
    }

    // 댓글 수정
    @Transactional
    public void updateComment(Long id, CommentDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException()
        );
        comment.updateComment(requestDto);
    }

}
