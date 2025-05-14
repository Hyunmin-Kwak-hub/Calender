package com.example.calender.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Calender {

    @Setter
    private Long id;
    @Setter
    private LocalDateTime date;
    private String writer;
    private String todo;
    private String password;

    public Calender(String writer, String todo, String password) {
        this.writer = writer;
        this.todo = todo;
        this.password = password;
    }

    public void update(LocalDateTime date, String writer, String todo) {
        this.date = date;
        this.writer = writer;
        this.todo = todo;
    }

    public void updateWriter(LocalDateTime date, String writer) {
        this.date = date;
        this.writer = writer;
    }

    public void updateTodo(LocalDateTime date, String todo) {
        this.date = date;
        this.todo = todo;
    }
}
