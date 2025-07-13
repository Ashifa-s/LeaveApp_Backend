package com.example.demo.dto;

import java.util.List;

public class AllDropdowns {

    private List<String> leaveTypes;
    private List<String> baseLocations;
    private List<String> subTeams;
    private List<String> projects;
    private List<String> leavestatus;


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
}
