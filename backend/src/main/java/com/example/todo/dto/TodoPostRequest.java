package com.example.todo.dto;

public class TodoPostRequest {

    private String text;

    public TodoPostRequest(){}

    public TodoPostRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
