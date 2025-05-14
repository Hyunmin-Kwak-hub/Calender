package com.example.calender.service;

import com.example.calender.dto.CalenderRequestDto;
import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.entity.Calender;
import com.example.calender.repository.CalenderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    @Override
    public CalenderResponseDto findCalenderById(Long id) {

        // 식별자가 없을때
        Calender calender = calenderRepository.findCalenderById(id);

        // null 방지
        if (calender == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        return new CalenderResponseDto(calender);
    }

    @Override
    public CalenderResponseDto updateCalender(Long id, String writer, String todo, String password) {

        // Calender 조회
        Calender calender = calenderRepository.findCalenderById(id);

        // Null 방지
        if (calender == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        // 필수값 검증
        if (writer == null || todo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The writer and todo are required valuse.");
        }

//        // 비밀번호 체크
//        if (calender.getPassword().equals(password)) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is wrong");
//        }

        // calender 수정일 적용
        LocalDateTime currentDate = LocalDateTime.now();

        // calender 수정
        calender.update(currentDate, writer, todo);

        return new CalenderResponseDto(calender);
    }


}
