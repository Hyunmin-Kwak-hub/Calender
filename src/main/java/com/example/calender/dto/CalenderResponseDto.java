package com.example.calender.dto;

import com.example.calender.entity.Calender;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CalenderResponseDto {
    private Long id;
    private LocalDateTime date;
    private String writer;
    private String todo;

    public CalenderResponseDto(Calender calender) {
        this.id = calender.getId();
        this.date = calender.getDate();
        this.writer = calender.getWriter();
        this.todo = calender.getTodo();
    }
}
