package com.tcs.tt.service;

import java.util.List;

import com.tcs.tt.domain.Employee;

public interface UserService {

	Employee save(Employee user);

	List<Employee> getList();
	
	Employee getEmployee(String empNo);

}
