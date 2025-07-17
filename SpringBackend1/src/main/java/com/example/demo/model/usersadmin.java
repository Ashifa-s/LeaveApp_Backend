package com.example.demo.model;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
import java.util.List;
 
@Document(collection = "LeaveStatus_admin")
public class usersadmin {
 
    @Id
    private String id;
 
    private String availedBy;
    private String subLobTeam;
 
    private String userId;
    private String leadId;
 
    private int userLevel;
    private int leadLevel;
 
    private String userEmail;
    private String leadEmail;
 
    private String leadComments;
    private String approvalstatus;
 
    private String startDate; 
    private String endDate;   
    private String leaveType; 
    private String leaveStatus; 
    private String projectSow;
 
    private List<String> notifyToRecipients;
 
    public usersadmin() {
    }
 
    public usersadmin(String id, String availedBy, String subLobTeam, String userId, String leadId,
                      int userLevel, int leadLevel, String userEmail, String leadEmail,
                      String leadComments, String approvalstatus, String startDate,
                      String endDate, String leaveType, String leaveStatus, 
                      String projectSow, List<String> notifyToRecipients) {
        this.id = id;
        this.availedBy = availedBy;
        this.subLobTeam = subLobTeam;
        this.userId = userId;
        this.leadId = leadId;
        this.userLevel = userLevel;
        this.leadLevel = leadLevel;
        this.userEmail = userEmail;
        this.leadEmail = leadEmail;
        this.leadComments = leadComments;
        this.approvalstatus = approvalstatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.leaveStatus = leaveStatus;
        this.projectSow = projectSow;
        this.notifyToRecipients = notifyToRecipients;
    }
 
 
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
 
    public String getAvailedBy() { return availedBy; }
    public void setAvailedBy(String availedBy) { this.availedBy = availedBy; }
 
    public String getSubLobTeam() { return subLobTeam; }
    public void setSubLobTeam(String subLobTeam) { this.subLobTeam = subLobTeam; }
 
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
 
    public String getLeadId() { return leadId; }
    public void setLeadId(String leadId) { this.leadId = leadId; }
 
    public int getUserLevel() { return userLevel; }
    public void setUserLevel(int userLevel) { this.userLevel = userLevel; }
 
    public int getLeadLevel() { return leadLevel; }
    public void setLeadLevel(int leadLevel) { this.leadLevel = leadLevel; }
 
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
 
    public String getLeadEmail() { return leadEmail; }
    public void setLeadEmail(String leadEmail) { this.leadEmail = leadEmail; }
 
    public String getLeadComments() { return leadComments; }
    public void setLeadComments(String leadComments) { this.leadComments = leadComments; }
 
    public String getApprovalstatus() { return approvalstatus; }
    public void setApprovalstatus(String approvalstatus) { this.approvalstatus = approvalstatus; }
 
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
 
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
 
    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }
 
    public String getLeaveStatus() { return leaveStatus; }
    public void setLeaveStatus(String leaveStatus) { this.leaveStatus = leaveStatus; }
 
    public String getProjectSow() { return projectSow; }
    public void setProjectSow(String projectSow) { this.projectSow = projectSow; }
 
    public List<String> getNotifyToRecipients() { return notifyToRecipients; }
    public void setNotifyToRecipients(List<String> notifyToRecipients) { this.notifyToRecipients = notifyToRecipients; }
}