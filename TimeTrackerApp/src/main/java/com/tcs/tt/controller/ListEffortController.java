package com.tcs.tt.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.tt.domain.EffortSpentDuring;
import com.tcs.tt.domain.Project;
import com.tcs.tt.domain.TimeEffort;
import com.tcs.tt.editors.EffortSpendEditor;
import com.tcs.tt.editors.ProjectEditor;
import com.tcs.tt.service.LogEffortsService;

@Controller
public class ListEffortController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private LogEffortsService effortsService;

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Project.class, new ProjectEditor());
		binder.registerCustomEditor(EffortSpentDuring.class, new EffortSpendEditor());
	}

	@ModelAttribute("allProjects")
	public List<Project> populateprojects() {
		ArrayList<Project> projects = new ArrayList<>();
		projects.add(new Project(-1, "Select Project"));
		projects.add(new Project(1, "AIS"));
		projects.add(new Project(2, "API Garden"));
		projects.add(new Project(3, "API Multidevice"));
		projects.add(new Project(4, "AWS"));
		projects.add(new Project(5, "DevOps-Automation"));
		projects.add(new Project(6, "DevOps-GESB"));
		projects.add(new Project(7, "Finland Transformation Dev"));
		projects.add(new Project(8, "Finland Transformation Operation"));
		projects.add(new Project(9, "OWF"));
		projects.add(new Project(10, "Phoenix"));
		return projects;
	}

	@ModelAttribute("allEffortSpendList")
	public List<EffortSpentDuring> populateAlleffortsSpend() {
		ArrayList<EffortSpentDuring> eff = new ArrayList<>();
		eff.add(new EffortSpentDuring(-1, "Select Project"));
		eff.add(new EffortSpentDuring(1, "NormalHours"));
		eff.add(new EffortSpentDuring(2, "OutOfOffice - Weekday"));
		eff.add(new EffortSpentDuring(3, "OutOfOffice - Weekend"));
		return eff;
	}

	// If Emp no is provided show for all employees otherwise show only for
	// particular employee
	@RequestMapping(value = "/show_efforts.html", method = RequestMethod.GET)
	public ModelAndView getListUsersView(@RequestParam(value = "emp", required = false) String empNo) {

		LOGGER.debug("Received request to get effort of employee list view ");
		ModelMap model = new ModelMap();
		int size = effortsService.getList().size();
		LOGGER.debug("Size of list {0}", size);
		if (empNo != null) {
			model.addAttribute("empNo", empNo);
			model.addAttribute("efforts", effortsService.getListofEmployee(empNo));
		} else {
			model.addAttribute("efforts", effortsService.getList());
		}
		return new ModelAndView("show_efforts", model);
	}

	// To edit the task
	@RequestMapping(value = "/edit_task.html", method = RequestMethod.GET)
	public ModelAndView getTaskofAssociateView(@RequestParam(value = "etaskId", required = false) int etaskId) {

		LOGGER.debug("Received request to view edit effort of employee View {0}", etaskId);
		ModelMap model = new ModelMap();
		TimeEffort effort = effortsService.getTimeEffort(etaskId);
		model.addAttribute("form", effort);
		return new ModelAndView("logEfforts", model);

	}

}
