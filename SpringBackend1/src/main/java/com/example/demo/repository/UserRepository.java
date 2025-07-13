package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Usermodel;

public interface UserRepository extends MongoRepository<Usermodel, String> {
	Optional<Usermodel> findByLeadId(String leadId);
	Optional<Usermodel> findByUserId(String userId); 
	Optional<Usermodel> findByUserLevelAndLeadLevel(int userLevel, int leadLevel);
}
