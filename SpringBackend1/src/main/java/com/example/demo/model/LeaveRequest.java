package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
	@Document(collection = "leave_requests")
	public class LeaveRequest {
	 
	    @Id
	    private String id;
	 
	    private String leaveType;//--
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	    private LocalDate startDate;//--
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	    private LocalDate endDate;//--
	    private String reason; 
	    private String availedBy;
	 
	    private List<String> backupContact;
	    private List<String> notifyTo;
	 
	    private String baseLocation;
	    private String projectSow;
	    private String subLobTeam;
	    private String leaveStatus; 
	    private String leadId;//--
	    private String UserId;//--
	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;
	    private String comments; 
	 
	   
	 
	    public String getId() {
	        return id;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }
	 
	    public String getLeaveType() {
	        return leaveType;
	    }
	    public void setLeaveType(String leaveType) {
	        this.leaveType = leaveType;
	    }
	 
	    public String getAvailedBy() {
	        return availedBy;
	    }
	    public void setAvailedBy(String availedBy) {
	        this.availedBy = availedBy;
	    }
	 
	    public LocalDate getStartDate() {
	        return startDate;
	    }
	    public void setStartDate(LocalDate startDate) {
	        this.startDate = startDate;
	    }
	 
	    public LocalDate getEndDate() {
	        return endDate;
	    }
	    public void setEndDate(LocalDate endDate) {
	        this.endDate = endDate;
	    }
	 
	    public String getReason() {
	        return reason;
	    }
	    public void setReason(String reason) {
	        this.reason = reason;
	    }
	 
	    public List<String> getBackupContacts() {
	        return backupContact;
	    }
	    public void setBackupContacts(List<String> backupContacts) {
	        this.backupContact = backupContacts;
	    }
	 
	    public List<String> getNotifyToRecipients() {
	        return notifyTo;
	    }
	    public void setNotifyToRecipients(List<String> notifyToRecipients) {
	        this.notifyTo = notifyToRecipients;
	    }
	 
	    public String getBaseLocation() {
	        return baseLocation;
	    }
	    public void setBaseLocation(String baseLocation) {
	        this.baseLocation = baseLocation;
	    }
	 
	    public String getProjectSow() {
	        return projectSow;
	    }
	    public void setProjectSow(String projectSow) {
	        this.projectSow = projectSow;
	    }
	 
	    public String getSubTeam() {
	        return subLobTeam;
	    }
	    public void setSubTeam(String subTeam) {
	        this.subLobTeam = subTeam;
	    }
	 
	    public String getLeaveStatus() {
	        return leaveStatus;
	    }
	    public void setLeaveStatus(String leaveStatus) {
	        this.leaveStatus = leaveStatus;
	    }
	    public String getleadId() {
	    	return leadId;
	    }
	    public void setleadId(String leadId) {
	    	this.leadId = leadId;
	    }
	    public String getUserId() {
	    	return UserId;
	    }
	    public void setUserId(String UserId) {
	    	this.UserId = UserId;
	    }
	 
	    public String getComments() {
	        return comments;
	    }
	    public void setComments(String comments) {
	        this.comments = comments;
	    }
	    public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}
	}

