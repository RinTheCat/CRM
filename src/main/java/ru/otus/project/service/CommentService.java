package ru.otus.project.service;

import org.springframework.stereotype.Service;
import ru.otus.project.domain.Comment;
import ru.otus.project.domain.Order;
import ru.otus.project.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllByOrder(Order order) {
        return commentRepository.findAllByOrder(order);
    }
}
