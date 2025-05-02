package com.example.todo.dto;

public class TodoPutRequest {
    private Boolean completed;

    public TodoPutRequest() {
    }

    public TodoPutRequest(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
