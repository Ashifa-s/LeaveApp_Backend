package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.usersadmin;
import com.example.demo.repository.UsersadminRepository; 

public interface UsersadminRepository extends MongoRepository<usersadmin, String> {

    Optional<usersadmin> findByLeadId(String leadId);

    Optional<usersadmin> findByUserId(String userId);

    Optional<usersadmin> findByUserLevelAndLeadLevel(int userLevel, int leadLevel);
}
