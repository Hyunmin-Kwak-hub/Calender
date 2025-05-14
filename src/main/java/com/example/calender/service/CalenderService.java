package com.example.calender.service;

import com.example.calender.dto.CalenderRequestDto;
import com.example.calender.dto.CalenderResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface CalenderService {

    CalenderResponseDto saveCalender(CalenderRequestDto requestDto);

    List<CalenderResponseDto> findAllCalenders();

    CalenderResponseDto findCalenderById(Long id);

    CalenderResponseDto updateCalender(Long id, String writer, String todo, String password);

    CalenderResponseDto updateWriter(Long id, String writer, String todo, String password);

    CalenderResponseDto updateTodo(Long id, String writer, String todo, String password);

    void deleteCalender(Long id);
}
