package com.tcs.tt.domain;

import java.io.Serializable;

public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer projectId;
	private String name;
	private String description;
	private String pONumber;
	private String startDate;

	public Project(Integer projectId, String description) {
		super();
		this.projectId = projectId;
		this.description = description;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getpONumber() {
		return pONumber;
	}

	public void setpONumber(String pONumber) {
		this.pONumber = pONumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "ProjectVO [projectId=" + projectId + ", name=" + name + ", description=" + description + ", pONumber="
				+ pONumber + ", startDate=" + startDate + "]";
	}

}