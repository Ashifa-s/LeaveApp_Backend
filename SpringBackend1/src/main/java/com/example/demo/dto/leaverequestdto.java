package com.example.demo.dto;
 
import java.time.LocalDate;
import java.util.List;
 
import com.fasterxml.jackson.annotation.JsonFormat;
 
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
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private String startDate;
 
    @NotNull
  //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private String endDate;
    private String availedBy;
    private String baseLocation;
    private String projectSow;
    private String leaveStatus;
    private String comments;
    
    private int userLevel;
    private int leadLevel;
    
    private String reason;
   
 
    private List<String> backupContact;
    private List<String> notifyTo;
 
    
   
    private String subLobTeam;
   
 
   
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
 
    public String getStartDate() {
        return startDate;
    }
 
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
 
    public String getEndDate() {
        return endDate;
    }
 
    public void setEndDate(String endDate) {
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
 
	public List<String> getBackupContact() {
	    return backupContact;
	}
	public void setBackupContact(List<String> backupContact) {
	    this.backupContact = backupContact;
	}
 
	public List<String> getNotifyTo() {
	    return notifyTo;
	}
	public void setNotifyTo(List<String> notifyTo) {
	    this.notifyTo = notifyTo;
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
 
	public String getSubLobTeam() {
		return subLobTeam;
	}
 
	public void setSubLobTeam(String subTeam) {
		this.subLobTeam = subTeam;
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
 