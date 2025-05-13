package com.example.calender.controller;

import com.example.calender.dto.CalenderRequestDto;
import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.service.CalenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calenders")
public class CalenderController {

    private final CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(@RequestBody CalenderRequestDto requestDto) {

        return new ResponseEntity<>(calenderService.saveCalender(requestDto), HttpStatus.CREATED);
    }
}
