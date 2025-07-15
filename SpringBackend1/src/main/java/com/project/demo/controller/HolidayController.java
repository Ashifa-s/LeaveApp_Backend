package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Holiday;
import com.example.demo.repository.HolidayRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping("/all")
    public List<Holiday> getAllHolidays() {
    	return holidayRepository.findAll();
    }
}

