package com.example.calender.service;

import com.example.calender.dto.CalenderRequestDto;
import com.example.calender.dto.CalenderResponseDto;

public interface CalenderService {

    CalenderResponseDto saveCalender(CalenderRequestDto requestDto);
}
