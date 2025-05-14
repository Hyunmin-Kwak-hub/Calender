package com.example.calender.controller;

import com.example.calender.dto.CalenderRequestDto;
import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.service.CalenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calenders")
public class CalenderController {

    private final CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    // 일정 생성
    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(@RequestBody CalenderRequestDto requestDto) {

        return new ResponseEntity<>(calenderService.saveCalender(requestDto), HttpStatus.CREATED);
    }

    // 전체 일정 조회
    @GetMapping
    public List<CalenderResponseDto> findAllCalenders() {

        return calenderService.findAllCalenders();
    }

    // 일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> findCalenderById(@PathVariable Long id) {

        return new ResponseEntity<>(calenderService.findCalenderById(id), HttpStatus.OK);
    }
}
