package com.example.calender.repository;

import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.entity.Calender;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class CalenderRepositoryImpl implements CalenderRepository {

    private final Map<Long, Calender> calenderList = new HashMap<>();

    @Override
    public Calender saveCalender(Calender calender) {

        // calender 식별자 자동 생성
        Long calenderId = calenderList.isEmpty() ? 1 : Collections.max(calenderList.keySet()) + 1;
        calender.setId(calenderId);
        
        // calender 날짜 자동 생성
        LocalDateTime currentDate = LocalDateTime.now();
        calender.setDate(currentDate);

        calenderList.put(calenderId, calender);

        return calender;
    }

    @Override
    public List<CalenderResponseDto> findAllCalenders() {

        // init List
        List<CalenderResponseDto> allCalenders = new ArrayList<>();

        // HashMap<Calender> -> List<CalenderResponseDto>
        for (Calender calender : calenderList.values()) {
            CalenderResponseDto responseDto = new CalenderResponseDto(calender);
            allCalenders.add(responseDto);
        }

        return allCalenders;
    }

    @Override
    public Calender findCalenderById(Long id) {

        return calenderList.get(id);
    }


}
