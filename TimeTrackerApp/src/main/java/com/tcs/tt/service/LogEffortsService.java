package com.tcs.tt.service;

import java.util.List;

import com.tcs.tt.domain.TimeEffort;

public interface LogEffortsService {

	TimeEffort save(TimeEffort effort);

	List<TimeEffort> getList();

	List<TimeEffort> getListofEmployee(String empId);	

	TimeEffort getTimeEffort(int eid);
}
