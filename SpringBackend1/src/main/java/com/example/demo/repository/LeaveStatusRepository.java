package com.example.demo.repository;

import com.example.demo.model.LeaveStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeaveStatusRepository extends MongoRepository<LeaveStatus, String> {
}
