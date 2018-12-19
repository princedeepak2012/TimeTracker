package com.tcs.tt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.tcs.tt.domain.Employee;
import com.tcs.tt.repository.UserRepository;
import com.tcs.tt.service.exception.UserAlreadyExistsException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserRepository repository;

	@Inject
	public UserServiceImpl(final UserRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Employee save(@NotNull @Valid final Employee user) {
		LOGGER.debug("Creating {}", user);
		Employee existing = repository.findOne(user.getEmployeeNo());
		if (existing != null) {
			throw new UserAlreadyExistsException(
					String.format("There already exists a user with id=%s", user.getEmployeeNo()));
		}
		return repository.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> getList() {
		LOGGER.debug("Retrieving the list of all Employees");
		return repository.findAll();
	}

	@Override
	public Employee getEmployee(String empNo) {
		LOGGER.debug("Retrieving the Employee object by empNo {0}",empNo);
		return repository.findByEmployeeNo(empNo);
	}

}
