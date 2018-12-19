package com.tcs.tt.domain;

import java.io.Serializable;

public class EffortSpentDuring implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer effortSid;	
	private String description;
	
	public Integer getEffortSid() {
		return effortSid;
	}
	public void setEffortSid(Integer effortSid) {
		this.effortSid = effortSid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public EffortSpentDuring(Integer effortSid, String description) {
		super();
		this.effortSid = effortSid;
		this.description = description;
	}	
/*	
	NormalHours
	- OutOfOffice - Weekday
	- OutOfOffice - Weekend*/
}
