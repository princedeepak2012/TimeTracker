package com.tcs.tt.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import com.google.common.base.Objects;

public class CreateEmployeeForm {

	@NotEmpty
	@Size(max = 64)
	private String password1;
	private String password2;

	@NotEmpty
	@Size(max = 64)
	private String employeeNo;

	@NotNull
	@Size(max = 64)
	private String name;

	// @NotNull
	@Size(max = 100)
	private String team;

	// @NotNull
	@Size(max = 200)
	private String emailId;

	// @NotNull
	@Size(max = 100)
	private String phoneNo;

	// @NotNull
	@Size(max = 100)
	private String status;

	// @NotNull
	@Size(max = 64)
	private String role;

	// @NotNull
	@Size(max = 64)
	private String createdDate;

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("employeeNo", employeeNo).add("password1", password1)
				.add("password2", password2).add("team", team).add("emailId", emailId).add("phoneNo", phoneNo)
				.add("status", status).add("role", role).add("createdDate", createdDate).toString();
	}
}
