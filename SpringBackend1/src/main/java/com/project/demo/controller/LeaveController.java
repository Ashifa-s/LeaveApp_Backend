package com.project.demo.controller;
 
import jakarta.validation.Valid;
 
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.leaverequestdto;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.LeaveResponse;
import com.example.demo.service.LeaveService;
 
@RestController
@RequestMapping("/api/leave")
@CrossOrigin (origins = "http://localhost:4200")
public class LeaveController {
 
    @Autowired
    private LeaveService leaveService;
 
    @PostMapping("/submit")
    public ResponseEntity<?> submitLeave(@RequestBody leaverequestdto dto) {
        try 
        {
            LeaveResponse saved = leaveService.submitLeaveRequest(dto);
            if(!saved.isSuccess()) {
            	return ResponseEntity.badRequest().body(Map.of("errors", saved.getErrors()));
            }
            return ResponseEntity.ok("Leave submitted successfully. ID: " + saved.getLeaverequest().getId());
        } 
        catch (RuntimeException ex) 
        {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}