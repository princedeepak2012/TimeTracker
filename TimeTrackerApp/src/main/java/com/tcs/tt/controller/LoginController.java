package com.tcs.tt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.tt.domain.Employee;
import com.tcs.tt.domain.Login;
import com.tcs.tt.service.UserService;

@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelMap model = new ModelMap();
		model.addAttribute("form", new Login());
		return new ModelAndView("login", model);
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute("form") Login form, BindingResult result) {
		LOGGER.debug("Received request to login", form, result);
		try {
			String username = form.getUsername();
			Employee emp = userService.getEmployee(username);
			if (emp != null) {
				if ((form.getUsername().equals(emp.getEmployeeNo()))
						&& (form.getPassword().equals(emp.getPassword()))) {
					return "redirect:/show_efforts.html?emp=" + username;
				}
				return "login.html";

			} else {

				return "redirect:/create_associate.html";
			}

		} catch (Exception e) {
			LOGGER.debug("Error while logging in", e);
			return "login.html";
		}
	}

}
