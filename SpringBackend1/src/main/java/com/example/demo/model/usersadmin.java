package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LeaveStatus_admin")
public class usersadmin {

    @Id
    private String id;

    private String name;
    private String sublob;
    private String userId;
    private String leadId;
    private int userLevel;
    private int leadLevel;
    private String userEmail;
    private String leadEmail;
    private String leadComments;
    private String approvalstatus;

    // Constructors
    public usersadmin() {}

    public usersadmin(String id, String name, String sublob, int userLevel, int leadLevel,
                      String userId, String leadId, String leadComments, String approvalstatus) {
        this.id = id;
        this.name = name;
        this.sublob = sublob;
        this.userLevel = userLevel;
        this.leadLevel = leadLevel;
        this.userId = userId;
        this.leadId = leadId;
        this.leadComments = leadComments;
        this.approvalstatus = approvalstatus;
    }

    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSublob() { return sublob; }
    public void setSublob(String sublob) { this.sublob = sublob; }

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
}
