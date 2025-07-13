package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AllDropdowns;
import com.example.demo.service.AllDropdownsDTO;

@RestController
@RequestMapping("/api/dropdowns")
@CrossOrigin (origins = "http://localhost:4200")
public class DropdownController {

    @Autowired
    private AllDropdownsDTO dropdownService;

    @GetMapping("/all")
    public AllDropdowns getAllDropdowns() {
        return dropdownService.getAllDropdowns();
    }
}
