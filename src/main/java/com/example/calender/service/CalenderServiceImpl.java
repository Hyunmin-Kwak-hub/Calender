package com.example.calender.service;

import com.example.calender.dto.CalenderRequestDto;
import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.entity.Calender;
import com.example.calender.repository.CalenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalenderServiceImpl implements CalenderService {

    private final CalenderRepository calenderRepository;

    public CalenderServiceImpl(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    @Override
    public CalenderResponseDto saveCalender(CalenderRequestDto requestDto) {

        Calender calender = new Calender(requestDto.getWriter(), requestDto.getTodo(), requestDto.getPassword());

        Calender saveCalender = calenderRepository.saveCalender(calender);

        return new CalenderResponseDto(saveCalender);
    }

    @Override
    public List<CalenderResponseDto> findAllCalenders() {

        // 전체조회
        List<CalenderResponseDto> allCalenders = calenderRepository.findAllCalenders();

        return allCalenders;
    }


}
