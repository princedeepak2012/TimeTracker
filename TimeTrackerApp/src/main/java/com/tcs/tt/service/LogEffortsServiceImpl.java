package com.tcs.tt.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.tcs.tt.domain.TimeEffort;
import com.tcs.tt.repository.LogEffortRepository;

@Service
@Validated
public class LogEffortsServiceImpl implements LogEffortsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private LogEffortRepository repository;

	@Override
	@Transactional
	public TimeEffort save(@NotNull TimeEffort effort) {
		LOGGER.debug("Saving the efforts");
		return repository.save(effort);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TimeEffort> getList() {
		LOGGER.debug("Retrieving the list of all efforts");
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TimeEffort> getListofEmployee(String empId) {
		LOGGER.debug("Retrieving the effort of particular employee {0}", empId);
		return repository.findByEmployeeNo(empId);
	}

	@Override
	public TimeEffort getTimeEffort(int eid) {
		LOGGER.debug("Retrieving the particular effort by taskid  {0}", eid);
		return repository.findByEmployeeTaskId(eid);
	}

}
