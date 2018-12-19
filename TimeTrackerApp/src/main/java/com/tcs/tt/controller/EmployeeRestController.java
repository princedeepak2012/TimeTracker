package com.tcs.tt.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.tt.domain.Employee;
import com.tcs.tt.service.UserService;
import com.tcs.tt.service.exception.UserAlreadyExistsException;

@RestController
public class EmployeeRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Employee createUser(@RequestBody @Valid final Employee user) {
		LOGGER.debug("Received request to create the {}", user);
		return userService.save(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<Employee> listUsers() {
		LOGGER.debug("Received request to list all users");
		return userService.getList();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
		return e.getMessage();
	}

}
