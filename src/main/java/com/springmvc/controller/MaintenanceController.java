package com.springmvc.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Maintenance;
import com.springmvc.service.MaintenanceService;

@Controller
public class MaintenanceController {

	@Autowired
	MaintenanceService maintenanceService;

	@RequestMapping(value = "/maintenance", method = RequestMethod.GET)
	public ModelAndView showTable(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("maintenance");
		mav.addObject("maintenance", new Maintenance());

		return mav;
	}

	@RequestMapping(value = "/maintenanceProcess", method = RequestMethod.POST)
	public ModelAndView maintenanceProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("maintenance") Maintenance maintenance) {
		ModelAndView mav = null;

		Maintenance tableDetails = maintenanceService.getTableDetails(maintenance);
		// User user = userService.validateUser(login);

		if (null != tableDetails) {
			mav = new ModelAndView("maintenance");
			mav.addObject("tableDetails", tableDetails);
		} else {
			mav = new ModelAndView("maintenance");
			mav.addObject("message", "No Tables in DB!!");
		}

		return mav;
	}

	protected Map referenceData(HttpServletRequest request) throws Exception {

		Map referenceData = new HashMap();
		
		Map<String,String> columnNames = new LinkedHashMap<String,String>();
		columnNames.put("US", "United Stated");
		columnNames.put("CHINA", "China");
		columnNames.put("SG", "Singapore");
		columnNames.put("MY", "Malaysia");
		referenceData.put("columnNames", columnNames);
		
		return referenceData;

	}

}
