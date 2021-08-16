package com.lti.mypack.service;

import java.util.List;



import com.lti.mypack.model.Application;
import com.lti.mypack.model.Customer;


public interface ApplicationService {
	
	public List<Application> getApplication();
	public Application addApplication(Application application);
	
	
	public boolean deleteApp(int applicationid);
	
	public Application updateApplication(Application application);
	
	public Application findApplication(int applicationid);

}

