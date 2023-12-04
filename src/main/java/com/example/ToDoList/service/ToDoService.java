package com.example.ToDoList.service;

import com.example.ToDoList.entity.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoService {
    List<ToDo> findAll();

    ToDo findById(long id);

    ToDo createToDo(ToDo toDo);

    ToDo updateToDo(ToDo toDo, long id);

    void deleteById(long id);
}
