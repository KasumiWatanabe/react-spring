import React, { useEffect, useState } from "react";
import { BackendService } from "../../../backend/BackendService";
import { FilterType } from "../../components/Filter";
import { SubmitHandler, useForm } from "react-hook-form";
import { Item } from "../../components/CheckboxList";
import { TodoTemplate } from "./TodoTemplate";

type Todo = {
  id: number;
  text: string;
  completed: boolean;
};

type ShowFilter = {
  [K in FilterType]: (todo: Todo) => boolean;
};

const showFilter: ShowFilter = {
  ALL: (todo) => true,
  INCOMPLETE: (todo) => !todo.completed,
  COMPLETED: (todo) => todo.completed,
};

type TodoCreateInput = {
  todoText: string;
};

export const TodoPage: React.FC = () => {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [filterType, setFilterType] = useState<FilterType>("ALL");

  useEffect(() => {
    BackendService.getTodos().then((response) => setTodos(response));
  }, []);

  const updateTodo = (id: number) => {
    const target = todos.find((todo) => todo.id === id);
    if (!target) {
      return;
    }
    BackendService.putTodo(id, !target.completed).then((response) =>
      setTodos(todos.map((todo) => (todo.id === response.id ? response : todo)))
    );
  };

  const deleteTodo = (id: number) => {
    const target = todos.find((todo) => todo.id === id);
    if (!target) {
      return;
    }
    BackendService.deleteTodo(id).then(() =>
      setTodos(todos.filter((todo) => todo.id !== id))
    );
  };

  const showTodos = todos.filter(showFilter[filterType]);

  const { register, handleSubmit } = useForm<TodoCreateInput>();

  const onSubmit: SubmitHandler<TodoCreateInput> = (data) => {
    if (!data.todoText) {
      return;
    }
    BackendService.postTodo(data.todoText).then((response) =>
      setTodos(todos.concat(response))
    );
  };

  const showItems: Item[] = showTodos.map((todo) => ({
    id: todo.id,
    text: todo.text,
    checked: todo.completed,
  }));

  return (
    <TodoTemplate
      todoText={{ register: { ...register("todoText") } }}
      filterType={filterType}
      checkboxItems={showItems}
      setFilterType={setFilterType}
      onClickCreate={handleSubmit(onSubmit)}
      onClickDelete={deleteTodo}
      onClickCheckbox={updateTodo}
    />
  );
};
