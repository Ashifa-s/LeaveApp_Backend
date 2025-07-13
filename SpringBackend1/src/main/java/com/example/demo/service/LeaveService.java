package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.leaverequestdto;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.Usermodel;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.UserRepository;

@Service
public class LeaveService {

	@Autowired
	private LeaveRequestRepository leaveRequestRepository;

	@Autowired
	private UserRepository userRepository;

	public LeaveRequest submitLeaveRequest(leaverequestdto dto) {

		
		Usermodel lead1 = userRepository.findByLeadId(dto.getLeadId())
				.orElseThrow(() -> new RuntimeException("Lead not found"));
		Usermodel user1 = userRepository.findByUserId(dto.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		
		Usermodel lead = userRepository.findByUserId(dto.getLeadId())
			    .orElseThrow(() -> new RuntimeException("Lead user not found"));

			Usermodel user = userRepository.findByUserId(dto.getUserId())
			    .orElseThrow(() -> new RuntimeException("Requesting user not found"));
		

		
				var leadLevel = lead.getLeadLevel();
				var userLevel = user.getLeadLevel();
				
				var leadUserLevel = lead.getUserLevel();
				var UserValueLevel = user.getLeadLevel();
		if (leadLevel > userLevel) 
		{
			throw new RuntimeException("Lead must have higher hierarchy level.");
		}
		if (leadUserLevel >UserValueLevel ) 
		{
			throw new RuntimeException("Lead must have higher hierarchy level.");
		}
		

		LeaveRequest leave = new LeaveRequest();
		leave.setUserId(dto.getUserId());
		leave.setleadId(dto.getLeadId());
		leave.setLeaveType(dto.getLeaveType());
		leave.setStartDate(dto.getStartDate());
		leave.setEndDate(dto.getEndDate());
		leave.setAvailedBy(dto.getAvailedBy());
		leave.setReason(dto.getReason());
		leave.setComments(dto.getComments());
		leave.setBackupContacts(dto.getBackupContacts());
		leave.setNotifyToRecipients(dto.getNotifyToRecipients());
		leave.setBaseLocation(dto.getBaseLocation());
		leave.setProjectSow(dto.getProjectSow());
		leave.setSubTeam(dto.getSubTeam());
		leave.setReason(dto.getReason());
		leave.setLeaveStatus(dto.getLeaveStatus());
		
		
		

		return leaveRequestRepository.save(leave);
	}
	
	 public Usermodel createUser(Usermodel user) 
	 {
	        String leadId = user.getLeadId();

	        if (leadId == null || leadId.isBlank()) {
	            throw new RuntimeException("Lead ID is required to create a user.");
	        }

	        boolean leadExists = userRepository.findByUserId(leadId).isPresent();

	        if (!leadExists) {
	            throw new RuntimeException("Cannot create user. Lead with ID " + leadId + " does not exist.");
	        }

	        return userRepository.save(user);
	   }
}
