package com.tcs.tt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import com.tcs.tt.domain.TimeEffortForm;
import com.tcs.tt.editors.EffortSpendEditor;
import com.tcs.tt.editors.ProjectEditor;
import com.tcs.tt.service.LogEffortsService;

@Controller
public class LogEffortController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogEffortController.class);
	@Autowired
	private LogEffortsService effortsService;

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Project.class, new ProjectEditor());
		binder.registerCustomEditor(EffortSpentDuring.class, new EffortSpendEditor());
	}

	@RequestMapping(value = "/logEfforts.html", method = RequestMethod.GET)
	public ModelAndView getLogRequestView(@RequestParam(value = "emp", required = false) String empNo) {
		LOGGER.debug("Received request for user logEfforts view");
		ModelMap model = new ModelMap();	
		model.addAttribute("emp", empNo);
		model.addAttribute("form", new TimeEffortForm());
		return new ModelAndView("logEfforts", model);
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

	@RequestMapping(value = "/logEfforts.html", method = RequestMethod.POST)
	public String logEffort(@ModelAttribute("form") TimeEffortForm form, BindingResult result) {
		LOGGER.debug("Received request to log  TimeEffort {}, with result={}", form, result);		
		try {
			Date date = new Date();			
			effortsService.save(new TimeEffort(form.getEmployeeTaskId(), form.getTaskDescription(), form.getEffort(), form.getEffortDate(),
					date.toString(), form.isOutofOffice(), form.getJiraId(), form.getEpicId(), form.getEmployeeNo(),
					form.getProjectId(),form.getEffortSpentDuring()));
		} catch (Exception e) {
			LOGGER.debug("Error while logging the efforts", e);
			result.reject("errorEfforts", "efforts.error");
			return "logEfforts";
		}
		return "redirect:/show_efforts.html?emp="+form.getEmployeeNo();
	}
}
