package com.tcs.tt.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.tt.domain.CreateEmployeeForm;
import com.tcs.tt.domain.Employee;
import com.tcs.tt.service.UserService;
import com.tcs.tt.service.exception.UserAlreadyExistsException;
import com.tcs.tt.validator.UserCreateFormPasswordValidator;

@Controller
public class CreateEmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateEmployeeController.class);
	private final UserService userService;
	private final UserCreateFormPasswordValidator passwordValidator;	
	public static final String CREATEASSOCIATE = "create_associate";

	@Inject
	public CreateEmployeeController(UserService userService, UserCreateFormPasswordValidator passwordValidator) {
		this.userService = userService;
		this.passwordValidator = passwordValidator;
	}

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(passwordValidator);
	}

	@RequestMapping(value = "/create_associate.html", method = RequestMethod.GET)
	public ModelAndView getCreateUserView() {
		LOGGER.debug("Received request for user create view");
		return new ModelAndView(CREATEASSOCIATE, "form", new CreateEmployeeForm());
	}

	@RequestMapping(value = "/create_associate.html", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("form") @Valid CreateEmployeeForm form, BindingResult result) {
		LOGGER.debug("Received request to create {}, with result={}", form, result);
		if (result.hasErrors()) {
			return CREATEASSOCIATE;
		}
		try {
			Date date = new Date();
			userService.save(new Employee(form.getEmployeeNo(), form.getName(), form.getTeam(), form.getEmailId(),
					form.getPhoneNo(), "ACTIVE", form.getRole(), form.getPassword1(), date.toString()));
		} catch (UserAlreadyExistsException e) {
			LOGGER.debug("Tried to create user with existing id", e);
			result.reject("user.error.exists");
			return CREATEASSOCIATE;
		}
		return "redirect:/show_efforts.html?emp=" + form.getEmployeeNo();

	}

}
