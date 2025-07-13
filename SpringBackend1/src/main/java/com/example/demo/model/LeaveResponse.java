package com.example.demo.model;

import java.util.List;

public class LeaveResponse {
	public LeaveRequest leaverequest;
	public boolean isSuccess;
	public List<String> errors;
	
	 public List<String> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<String> errors) {
	        this.errors = errors;
	    }
}
