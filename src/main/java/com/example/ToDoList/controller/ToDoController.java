package com.example.ToDoList.controller;

import com.example.ToDoList.entity.ToDo;
import com.example.ToDoList.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAll(){
        return toDoService.findAll();
    }

    @GetMapping("{id}")
    public ToDo getById(@PathVariable long id){
        return toDoService.findById(id);
    }

    @PostMapping
    public ToDo postToDo(@RequestBody ToDo toDo){
        return toDoService.createToDo(toDo);
    }

    @PutMapping("{id}")
    public ToDo updateToDo(@RequestBody ToDo toDo,@PathVariable("id") long id)
    {
        return toDoService.updateToDo(toDo,id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long id)
    {
        toDoService.deleteById(id);
    }

}
