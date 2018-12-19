package com.tcs.tt.domain;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@NotNull
	@Size(max = 64)
	@Column(name = "employeeNo", nullable = false, updatable = false)
	private String employeeNo;

	@NotNull
	@Size(max = 64)
	@Column(name = "name", nullable = false)
	private String name;

	@Size(max = 100)
	@Column(name = "team", nullable = false)
	private String team;

	@Size(max = 200)
	@Column(name = "emailId", nullable = false)
	private String emailId;

	@Size(max = 100)
	@Column(name = "phoneNo", nullable = false)
	private String phoneNo;

	@Size(max = 100)
	@Column(name = "status", nullable = false)
	private String status;

	@Size(max = 64)
	@Column(name = "role", nullable = false)
	private String role;

	@NotNull
	@Size(max = 64)
	@Column(name = "password", nullable = false)
	private String password;

	@Size(max = 64)
	@Column(name = "createdDate", nullable = false)
	private String createdDate;

	public Employee() {
	}

	public Employee(String employeeNo, String name, String team, String emailId, String phoneNo, String status,
			String role, String password, String createdDate) {
		super();
		this.employeeNo = employeeNo;
		this.name = name;
		this.team = team;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.status = status;
		this.role = role;
		this.password = password;
		this.createdDate = createdDate;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public String getName() {
		return name;
	}

	public String getTeam() {
		return team;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getStatus() {
		return status;
	}

	public String getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", employeeNo).add("password", password).toString();
	}
}
