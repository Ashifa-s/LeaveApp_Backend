package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Usermodel;

public class AllDropdowns {

    private List<String> leaveTypes;
    private List<String> baseLocations;
    private List<String> subTeams;
    private List<String> projects;
    private List<String> leavestatus;
    private List<Usermodel> User;

    public List<String> getLeaveTypes() {
        return leaveTypes;
    }

    public void setLeaveTypes(List<String> leaveTypes) {
        this.leaveTypes = leaveTypes;
    }

    public List<String> getBaseLocations() {
        return baseLocations;
    }

    public void setBaseLocations(List<String> baseLocations) {
        this.baseLocations = baseLocations;
    }

    public List<String> getSubTeams() {
        return subTeams;
    }

    public void setSubTeams(List<String> subTeams) {
        this.subTeams = subTeams;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getStatus() {
        return leavestatus;
    }

    public void setStatus(List<String> status) {
        this.leavestatus = status;
    }

	public List<Usermodel> getUser() {
		return User;
	}

	public void setUser(List<Usermodel> user) {
		this.User = user;
	}

	
		
	
}
