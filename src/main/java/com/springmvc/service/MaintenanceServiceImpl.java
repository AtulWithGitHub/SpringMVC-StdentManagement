package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.MaintenanceDao;
import com.springmvc.model.Maintenance;

public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	public MaintenanceDao maintenanceDao;

	public Maintenance getTableDetails(Maintenance tableDetails) {
		
		return maintenanceDao.getTableDetails(tableDetails);
	}

}
