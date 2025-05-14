package com.example.calender.repository;

import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.entity.Calender;

import java.util.List;

public interface CalenderRepository {

    Calender saveCalender(Calender calender);

    List<CalenderResponseDto> findAllCalenders();
}
