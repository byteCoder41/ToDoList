package com.example.ToDoList.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ToDo")
public class ToDo {
    @Id
    @GeneratedValue
            (
                    strategy = GenerationType.IDENTITY
            )
    private long id;
    private String title;
    private String description;
    private String completed;
}
