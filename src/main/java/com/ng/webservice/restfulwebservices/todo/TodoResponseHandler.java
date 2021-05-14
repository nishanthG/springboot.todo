package com.ng.webservice.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4500")
class TodoResponseHandler {

    @Autowired
    private todoHardcodedSrevice todoService;

    @GetMapping(path = "/users/{username}/todos")
    public List<Todos> getAllItems(@PathVariable String username){
        return todoService.findAllTodos();
    }

    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todos getTodo(@PathVariable String username,@PathVariable int id){
        return todoService.findbyID(id);
    }

    @PutMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Todos> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todos todo){
        Todos updatedTodo = todoService.saveTodo(todo);
        return new ResponseEntity<Todos>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping(path = "/users/{username}/todos")
    public ResponseEntity<Todos> addTodo(@PathVariable String username, @RequestBody Todos todo){
        Todos addedTodo = todoService.saveTodo(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable int id){
        Todos todo = todoService.deleteTodo(id);
        if(todo!= null){
             return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build(); 
    }
}