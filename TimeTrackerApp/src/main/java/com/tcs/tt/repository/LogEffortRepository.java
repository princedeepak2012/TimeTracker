package com.tcs.tt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.tt.domain.TimeEffort;

public interface LogEffortRepository extends JpaRepository<TimeEffort, String> {

	List<TimeEffort> findByEmployeeNo(String employeeno);
	
	TimeEffort findByEmployeeTaskId(int taskId);


}
