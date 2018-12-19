package com.tcs.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.tt.domain.Employee;

public interface UserRepository extends JpaRepository<Employee, String> {

	Employee findByEmployeeNo(String employeeno);
}
