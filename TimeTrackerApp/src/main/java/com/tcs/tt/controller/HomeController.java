package com.tcs.tt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.tt.service.UserService;

import javax.inject.Inject;

@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	private final UserService userService;

	@Inject
	public HomeController(final UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/home.html")
	public ModelAndView getListUsersView() {
		LOGGER.debug("Received request to get user list view");
		ModelMap model = new ModelMap();
		model.addAttribute("users", userService.getList());
		return new ModelAndView("home", model);
	}

}
