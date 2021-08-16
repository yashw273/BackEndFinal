package com.lti.mypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.mypack.model.Account;
import com.lti.mypack.model.Application;
import com.lti.mypack.model.Customer;
import com.lti.mypack.service.ApplicationService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("homeloanrest/api")
public class ApplicationController {
	
	@Autowired
	ApplicationService appService;
	
	@GetMapping("/application")
	public List<Application> getAll(){
		return appService.getApplication();
	}
	
	@PostMapping("/application")
	public Application addApplication(@RequestBody Application application) {
		return appService.addApplication(application);
	}
	@PutMapping("/application/{applicationid}")
	public Application updateAccount( @RequestBody Application application) {
		return appService.updateApplication(application);
	}
	
	
	@DeleteMapping("/application/{applicationid}")
	public boolean deleteApp(@PathVariable(value="applicationid") int applicationid) {
		return appService.deleteApp(applicationid);
}
	
	@GetMapping("/application/{applicationid}")
	public Application findApplication(@PathVariable(value="applicationid")int applicationid)
	{return appService.findApplication(applicationid);}
}

