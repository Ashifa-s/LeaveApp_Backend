package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.leaverequestdto;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.LeaveResponse;
import com.example.demo.model.Usermodel;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.UserRepository;

@Service
public class LeaveService {

	@Autowired
	private LeaveRequestRepository leaveRequestRepository;

	@Autowired
	private UserRepository userRepository;
	private static final int PLANNED_LEAVE_ADVANCE_DAYS = 28;
	public LeaveResponse submitLeaveRequest(leaverequestdto dto) {

//		
//		Usermodel lead1 = userRepository.findByLeadId(dto.getLeadId())
//				.orElseThrow(() -> new RuntimeException("Lead not found"));
//		Usermodel user1 = userRepository.findByUserId(dto.getUserId())
//				.orElseThrow(() -> new RuntimeException("User not found"));
		
		
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
		
        LeaveResponse response=new LeaveResponse();
		LeaveRequest leave = new LeaveRequest();
		leave.setUserId(dto.getUserId());
		leave.setleadId(dto.getLeadId());
		leave.setLeaveType(dto.getLeaveType());
		leave.setStartDate(dto.getStartDate());
		leave.setEndDate(dto.getEndDate());
		leave.setAvailedBy(dto.getAvailedBy());
		leave.setReason(dto.getReason());
		leave.setComments(dto.getComments());
		leave.setBackupContacts(dto.getBackupContact());
		leave.setNotifyToRecipients(dto.getNotifyTo());
		leave.setBaseLocation(dto.getBaseLocation());
		leave.setProjectSow(dto.getProjectSow());
		leave.setSubTeam(dto.getSubLobTeam());
		leave.setReason(dto.getReason());
		leave.setLeaveStatus(dto.getLeaveStatus());
		LocalDateTime now = LocalDateTime.now();
		leave.setCreatedAt(now);
		leave.setUpdatedAt(now);
		leave.setApprovalstatus("Pending");
		
	      List<String> errors = new ArrayList<>();
	       // === REQUIRED FIELD VALIDATIONS ===
	       if (isBlank(leave.getLeaveType())) errors.add("Leave Type is required.");
	       if (isBlank(leave.getAvailedBy())) errors.add("Availed By is required.");
	       if (isBlank(leave.getReason())) errors.add("Reason is required.");
	       if (leave.getBackupContacts() == null || leave.getBackupContacts().isEmpty())
	           errors.add("Backup Contact is required.");
	       if (leave.getNotifyToRecipients() == null || leave.getNotifyToRecipients().isEmpty())
	           errors.add("Notify To Recipient is required.");
	       if (isBlank(leave.getBaseLocation())) errors.add("Base Location is required.");
	       if (isBlank(leave.getProjectSow())) errors.add("Project/SOW is required.");
	       if (isBlank(leave.getSubTeam())) errors.add("Sub-LOB/Team is required.");
	       // === DATE VALIDATION ===
	       LocalDate start = leave.getStartDate();
	       LocalDate end = leave.getEndDate();
	       LocalDate today = LocalDate.now();
	       if (start == null) errors.add("Start Date is required.");
	       if (end == null) errors.add("End Date is required.");
	       if (start != null && end != null) {
	           if (end.isBefore(start)) errors.add("End Date cannot be before Start Date.");
	           if ("Planned Leave".equalsIgnoreCase(leave.getLeaveType()) &&
	               start.minusDays(PLANNED_LEAVE_ADVANCE_DAYS).isBefore(today)) {
	               errors.add("Planned Leave must be applied at least " + PLANNED_LEAVE_ADVANCE_DAYS + " days in advance.");
	           }
	       }
	       // === OVERLAPPING LEAVE CHECK ===
	       if (leave.getAvailedBy() != null && start != null && end != null) {
	           List<LeaveRequest> existing = leaveRequestRepository.findByAvailedBy(leave.getAvailedBy());
	           for (LeaveRequest lr : existing) {
	               LocalDate exStart = lr.getStartDate();
	               LocalDate exEnd = lr.getEndDate();
	               if (exStart != null && exEnd != null &&
	                   !(end.isBefore(exStart) || start.isAfter(exEnd))) {
	                   errors.add("Overlapping leave already exists for the same user.");
	                   break;
	               }
	           }
	       }
	       if (!errors.isEmpty()) {
//	           return ResponseEntity.badRequest().body(Map.of("errors", errors));
	          response.isSuccess=false;
	          response.setErrors(errors);
	          return response;
	       }
	       
	       // === SET SYSTEM FIELDS ===
	       leave.setLeaveStatus("Pending");
	       leave.setCreatedAt(LocalDateTime.now());
	       leave.setUpdatedAt(LocalDateTime.now());

	       var saved = leaveRequestRepository.save(leave);
	      response.isSuccess=true;
	      response.leaverequest=leave;
		return response;
		
	}
	private boolean isBlank(String val) {
	       return val == null || val.trim().isEmpty();
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


