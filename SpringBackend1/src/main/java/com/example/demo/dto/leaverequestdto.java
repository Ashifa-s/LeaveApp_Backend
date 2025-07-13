package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class leaverequestdto {

    @NotBlank
    private String userId;

    @NotBlank
    private String leadId;

    @NotBlank
    private String leaveType;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
    
    private int userLevel;
    private int leadLevel;
    
    private String reason; 
    private String availedBy;
 
    private List<String> backupContacts;
    private List<String> notifyToRecipients;
 
    private String baseLocation;
    private String projectSow;
    private String subTeam;
    private String leaveStatus; 
    private String comments;

   
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
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
    
    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userlevel) {
        this.userLevel = userlevel;
    }
    public int getLeadLevel() {
        return leadLevel;
    }

    public void setLeadLevel(int leadlevel) {
        this.leadLevel = leadlevel;
    }

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAvailedBy() {
		return availedBy;
	}

	public void setAvailedBy(String availedBy) {
		this.availedBy = availedBy;
	}

	public List<String> getBackupContacts() {
		return backupContacts;
	}

	public void setBackupContacts(List<String> backupContacts) {
		this.backupContacts = backupContacts;
	}

	public List<String> getNotifyToRecipients() {
		return notifyToRecipients;
	}

	public void setNotifyToRecipients(List<String> notifyToRecipients) {
		this.notifyToRecipients = notifyToRecipients;
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
		return subTeam;
	}

	public void setSubTeam(String subTeam) {
		this.subTeam = subTeam;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}

