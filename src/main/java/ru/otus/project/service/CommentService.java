package ru.otus.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.project.domain.Comment;
import ru.otus.project.repository.CommentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    public void editText(long id, String newText) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isEmpty()) throw new EntityNotFoundException(String.format("Not found with id=%s", id));
        comment.get().setText(newText);
    }
}
