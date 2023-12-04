package com.example.ToDoList.service.serviceImpl;

import com.example.ToDoList.entity.ToDo;
import com.example.ToDoList.exception.ResourceNotFoundException;
import com.example.ToDoList.repository.ToDoRepository;
import com.example.ToDoList.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo findById(long id) {
         return   toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo","id",id));
    }

    @Override
    public ToDo createToDo(ToDo toDo) {
        ToDo toDo1 = new ToDo();
        toDo1.setTitle(toDo.getTitle());
        toDo1.setDescription(toDo.getDescription());
        toDo1.setCompleted(toDo.getCompleted());
        toDoRepository.save(toDo1);
        return toDo1;
    }

    @Override
    public ToDo updateToDo(ToDo toDo, long id) {
        ToDo toDo1 = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo","id",id));
        toDo1.setCompleted(toDo.getCompleted());
        toDoRepository.save(toDo1);
        return  toDo1;
    }

    @Override
    public void deleteById(long id) {
        ToDo toDo1 = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo","id",id));
        toDoRepository.delete(toDo1);
    }

}
