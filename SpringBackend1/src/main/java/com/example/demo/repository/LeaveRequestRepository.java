package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.LeaveRequest;

public interface LeaveRequestRepository extends MongoRepository<LeaveRequest, String> {
	
	}


