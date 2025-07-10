package com.project.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.leaverequestdto;
import com.example.demo.model.LeaveRequest;
import com.example.demo.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/submit")
    public ResponseEntity<?> submitLeave(@Valid @RequestBody leaverequestdto dto) {
        try 
        {
            LeaveRequest saved = leaveService.submitLeaveRequest(dto);
            return ResponseEntity.ok("Leave submitted successfully. ID: " + saved.getId());
        } 
        catch (RuntimeException ex) 
        {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}
