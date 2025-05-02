package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos(String userId) {
        List<Todo> allTodos = new ArrayList<>();
        todoRepository.findAllByUserId(userId).forEach(allTodos::add);
        return allTodos;
    }

    public Todo addTodo(String userId, String text) {
        Todo newTodo = new Todo(text, false, userId);
        todoRepository.save(newTodo);
        return newTodo;
    }

    public Todo updateTodo(Long todoId, Boolean completed) {
        Todo todo = todoRepository.findById(todoId).get();
        todo.setCompleted(completed);
        return todo;
    }

    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
