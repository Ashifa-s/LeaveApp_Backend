package com.project.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.usersadmin;
import com.example.demo.service.usersadminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usersadmin")
@CrossOrigin(origins = "*")
public class UsersadminController {

    @Autowired
    private usersadminService service;

    @GetMapping("/all")
    public List<usersadmin> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<usersadmin> getUserById(@PathVariable String id) {
        return service.getUserById(id);
    }

    @GetMapping("/by-userId/{userId}")
    public Optional<usersadmin> getByUserId(@PathVariable String userId) {
        return service.getByUserId(userId);
    }

    @GetMapping("/by-leadId/{leadId}")
    public Optional<usersadmin> getByLeadId(@PathVariable String leadId) {
        return service.getByLeadId(leadId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody usersadmin user) { 
    
    try 
    {
    	var saveduser=service.createUser(user);
        return ResponseEntity.ok("Leave submitted successfully. ID: " + saveduser.getId());
    } 
    catch (RuntimeException ex) 
    {
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    }
    }
    @PutMapping("/update/{id}")
    public usersadmin updateUser(@PathVariable String id, @RequestBody usersadmin user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteUser(id);
        
    }
   
    @GetMapping("/approvedleaves")
    public List<usersadmin> getApprovedLeaves(){
    	return service.getBystatus();
    }

}
