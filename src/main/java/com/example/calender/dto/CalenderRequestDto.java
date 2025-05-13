package com.example.calender.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CalenderRequestDto {
    private String writer;
    private String todo;
    private String password;

}
