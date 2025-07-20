package com.example.demo.model;
 
import java.util.List;
 
public class LeaveResponse {
    
    private LeaveRequest leaverequest;
    private boolean success;
    private List<String> errors;
 
    // Getter and Setter for leaveRequest
    public LeaveRequest getLeaverequest() {
        return leaverequest;
    }
 
    public void setLeaverequest(LeaveRequest leaverequest) {
        this.leaverequest = leaverequest;
    }
 
    // Getter and Setter for success
    public boolean isSuccess() {
        return success;
    }
 
    public void setSuccess(boolean success) {
        this.success = success;
    }
 
    // Getter and Setter for errors
    public List<String> getErrors() {
        return errors;
    }
 
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
 