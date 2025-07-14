package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UsersadminRepository;
import com.example.demo.model.usersadmin;

import java.util.List;
import java.util.Optional;

@Service
public class usersadminService {
    
    @Autowired
    private UsersadminRepository usersadminRepository;

    public List<usersadmin> getAllUsers() {
        return usersadminRepository.findAll();
    }

    public Optional<usersadmin> getUserById(String id) {
        return usersadminRepository.findById(id);
    }

    public Optional<usersadmin> getByUserId(String userId) {
        return usersadminRepository.findByUserId(userId);
    }

    public Optional<usersadmin> getByLeadId(String leadId) {
        return usersadminRepository.findByLeadId(leadId);
    }

    public usersadmin createUser(usersadmin user) {
        return usersadminRepository.save(user);
    }

    public usersadmin updateUser(String id, usersadmin updatedUser) {
        updatedUser.setId(id);
        return usersadminRepository.save(updatedUser);
    }

    public void deleteUser(String id) {
        usersadminRepository.deleteById(id);
    }
		
	}

