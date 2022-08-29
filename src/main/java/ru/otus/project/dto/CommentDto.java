package ru.otus.project.dto;

import ru.otus.project.domain.Comment;

public class CommentDto {

    private long id;

    private String text;

    public CommentDto(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment toDomainObject() {
        return null;
    }

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getText());
    }
}
