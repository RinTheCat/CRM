package ru.otus.project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.project.domain.Comment;
import ru.otus.project.service.CommentService;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @DeleteMapping("/api/comment/{id}")
    public void deleteComment(@PathVariable long id) {
        commentService.deleteById(id);
    }

    @PutMapping("/api/comment/{id}")
    public void editCommentText(@PathVariable long id, @RequestParam String newText) {
        commentService.editText(id, newText);
    }
}
