package com.ng.webservice.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class todoHardcodedSrevice {
    private static List<Todos> user_todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        user_todos.add(new Todos(++idCounter, "bunny", "Learn React", new Date(), false));
        user_todos.add(new Todos(++idCounter, "bunny", "Build a portfolio website", new Date(), false));
        user_todos.add(new Todos(++idCounter, "bunny", "Learn Srping Boot", new Date(), false));
        user_todos.add(new Todos(++idCounter, "bunny", "build a site to manage stuff", new Date(), false));
        user_todos.add(new Todos(++idCounter, "bunny", "Start Free lancing", new Date(), false));
        user_todos.add(new Todos(++idCounter, "bunny", "Learn GIT - Projects", new Date(), false));
    }

    public List<Todos> findAllTodos() {
        return user_todos;
    }

    public Todos saveTodo(Todos todo){
        if(todo.getId() == -1 || todo.getId() == 0){
            todo.setId(++idCounter);
            user_todos.add(todo);
        }
        else {
            deleteTodo(todo.getId());
            user_todos.add(todo);
        }
        return todo;
    }

    public Todos deleteTodo(long id) {
        Todos todo = findbyID(id);
        if (todo == null) {
            return null;
        }
        user_todos.remove(todo);
        return todo;
    }

    public Todos findbyID(long id) {
        for (Todos todo : user_todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}