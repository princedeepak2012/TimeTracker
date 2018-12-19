package com.tcs.tt.domain;

import javax.validation.constraints.Size;

import com.google.common.base.Objects;

public class TimeEffortForm {

	// @NotEmpty
	@Size(max = 64)
	private int  employeeTaskId;

	//@NotEmpty
	@Size(max = 64)
	private String taskDescription;

	//@NotEmpty
	@Size(max = 64)
	private String effort;

	//@NotEmpty
	@Size(max = 64)
	private String effortDate;

	// @NotEmpty
	@Size(max = 64)
	private String createdDate;

	// @NotEmpty
	// @Size(max = 64)
	private boolean outofOffice;

	//@NotEmpty
	@Size(max = 64)
	private String jiraId;

	//@NotEmpty
	@Size(max = 64)
	private String epicId;

	@Size(max = 64)
	private String employeeNo;

	//@NotEmpty
	@Size(max = 64)
	private String projectId;
	
	@Size(max = 64)	
	private String effortSpentDuring;

	public int  getEmployeeTaskId() {
		return employeeTaskId;
	}

	public void setEmployeeTaskId(int  employeeTaskId) {
		this.employeeTaskId = employeeTaskId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getEffortDate() {
		return effortDate;
	}

	public void setEffortDate(String effortDate) {
		this.effortDate = effortDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isOutofOffice() {
		return outofOffice;
	}

	public void setOutofOffice(boolean outofOffice) {
		this.outofOffice = outofOffice;
	}

	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public String getEpicId() {
		return epicId;
	}

	public void setEpicId(String epicId) {
		this.epicId = epicId;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	

	public String getEffortSpentDuring() {
		return effortSpentDuring;
	}

	public void setEffortSpentDuring(String effortSpentDuring) {
		this.effortSpentDuring = effortSpentDuring;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("employeeTaskId", employeeTaskId)
				.add("taskDescription", taskDescription).add("effort", effort).add("effortDate", effortDate)
				.add("createdDate", createdDate).add("outofOffice", outofOffice).add("jiraId", jiraId)
				.add("epicId", epicId).add("employeeNo", employeeNo).toString();
	}
}
