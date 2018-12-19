package com.tcs.tt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "time_effort")
public class TimeEffort {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	// @Size(max = 64)
	@Column(name = "employeeTaskId")
	private int employeeTaskId;

	// @NotNull
	@Size(max = 200)
	@Column(name = "taskDescription")
	private String taskDescription;

	// @NotNull
	@Size(max = 2)
	@Column(name = "effort")
	private String effort;

	// @NotNull
	@Size(max = 10)
	@Column(name = "effortDate")
	private String effortDate;

	@Size(max = 50)
	@Column(name = "createdDate")
	private String createdDate;

	@Column(name = "outofOffice")
	private boolean outofOffice;

	// @NotNull
	@Size(max = 20)
	@Column(name = "jiraId")
	private String jiraId;

	// @NotNull
	@Size(max = 20)
	@Column(name = "epicId")
	private String epicId;

	@Size(max = 10)
	@Column(name = "employeeNo")
	private String employeeNo;

	// @NotNull
	@Size(max = 20)
	@Column(name = "projectId")
	private String projectId;

	@Size(max = 100)
	@Column(name = "effortSpentDuring")
	private String effortSpentDuring;

	public TimeEffort() {
	}

	public TimeEffort(int employeeTaskId, String taskDescription, String effort, String effortDate, String createdDate,
			boolean outofOffice, String jiraId, String epicId, String employeeNo, String projectId,
			String effortSpentDuring) {
		super();
		this.employeeTaskId = employeeTaskId;
		this.taskDescription = taskDescription;
		this.effort = effort;
		this.effortDate = effortDate;
		this.createdDate = createdDate;
		this.outofOffice = outofOffice;
		this.jiraId = jiraId;
		this.epicId = epicId;
		this.employeeNo = employeeNo;
		this.projectId = projectId;
		this.effortSpentDuring = effortSpentDuring;
	}

	public int getEmployeeTaskId() {
		return employeeTaskId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public String getEffort() {
		return effort;
	}

	public String getEffortDate() {
		return effortDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public boolean isOutofOffice() {
		return outofOffice;
	}

	public String getJiraId() {
		return jiraId;
	}

	public String getEpicId() {
		return epicId;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getEffortSpentDuring() {
		return effortSpentDuring;
	}

	@Override
	public String toString() {
		return "TimeEffort [employeeTaskId=" + employeeTaskId + ", taskDescription=" + taskDescription + ", effort="
				+ effort + ", effortDate=" + effortDate + ", createdDate=" + createdDate + ", outofOffice="
				+ outofOffice + ", jiraId=" + jiraId + ", epicId=" + epicId + ", employeeNo=" + employeeNo
				+ ", projectId=" + projectId + "]";
	}

}
