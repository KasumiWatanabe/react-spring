package com.example.todo.exception;

public class TodoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public TodoNotFoundException(Long id) {
        super("TodoID：" + id + "は見つかりません。");
    }
}
