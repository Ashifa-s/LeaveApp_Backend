package com.project.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.leaverequestdto;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.Usermodel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LeaveService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LeaveService leaveService;

//    @PostMapping("/submit")
//    public ResponseEntity<?> submitLeave(@Valid @RequestBody leaverequestdto dto) {
//        try {
////            LeaveRequest saved = leaveService.submitLeaveRequest(dto);
//            return ResponseEntity.ok("Leave submitted successfully. ID: " + saved.getId());
//        } catch (RuntimeException ex) {
//            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
//        }
//    }

	@PostMapping("/insertuser")
	public ResponseEntity<?> addUser(@RequestBody Usermodel user) {
		try 
		{
			var saved = leaveService.createUser(user);
			return ResponseEntity.ok("User Created successfully. ID: " + saved.getId());
		}
		catch(RuntimeException ex) 
		{
			 return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
		}
	}
}
