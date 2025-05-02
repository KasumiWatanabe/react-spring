package com.example.todo.dto;

public class TodoResponse {
    private Long id;
    private String text;
    private Boolean completed;

    public TodoResponse() {}

    public TodoResponse(Long id, String text, Boolean completed) {
        this.id = id;
        this.text = text;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
