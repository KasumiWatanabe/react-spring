package com.example.todo.controller;

import com.example.todo.dto.TodoPostRequest;
import com.example.todo.dto.TodoPutRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("api/todos")
    public List<TodoResponse> getAllTodos(){

        // userIdは仮で固定値
        String userId = "user-001";

        List<Todo> todos =  todoService.getAllTodos(userId);
        return todos.stream()
                .map(todo -> new TodoResponse(todo.getId(), todo.getText(), todo.getCompleted()))
                .collect(Collectors.toList());
    }

    @PostMapping("api/todos")
    public  TodoResponse addTodo(@RequestBody TodoPostRequest requestBody) {

        // userIdは仮で固定値
        String userId = "user-001";

        Todo todo = todoService.addTodo(userId, requestBody.getText());
        return new TodoResponse(todo.getId(), todo.getText(), todo.getCompleted());
    }

    @PutMapping("api/todos/{todoId}")
    public TodoResponse updateTodo(@PathVariable("todoId") Long todoId, @RequestBody TodoPutRequest requestBody) {
        Todo todo = todoService.updateTodo(todoId, requestBody.getCompleted());
        return new TodoResponse(todo.getId(), todo.getText(), todo.getCompleted());
    }

    @DeleteMapping("api/todos/{todoId}")
    public void deleteTodo (@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
    }
}
