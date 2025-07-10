package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Usermodel {

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

  
    public Usermodel() {}

    public Usermodel(String id, String name, String sublob, int Userlevel, int Leadlevel, String UserId, String LeadId) {
        this.id = id;
        this.name = name;
        this.sublob = sublob;
        this.userLevel = Userlevel;
        this.leadLevel=Leadlevel;
        this.userId=UserId;
        this.leadId=LeadId;
        
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSublob() {
        return sublob;
    }

    public void setSublob(String sublob) {
        this.sublob = sublob;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int Userlevel) {
        this.userLevel = Userlevel;
    }
    public int getLeadLevel() {
        return leadLevel;
    }

    public void setLeadLevel(int Leadlevel) {
        this.leadLevel = Leadlevel;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		userId = userId;
	}
	public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String LeadId) {
        this.leadId = LeadId;
    }

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String _userEmail) {
		userEmail = _userEmail;
	}

	public String getLeadEmail() {
		return leadEmail;
	}

	public void setLeadEmail(String _leadEmail) {
		leadEmail = _leadEmail;
	}
}

