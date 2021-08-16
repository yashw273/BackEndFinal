package com.lti.mypack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.mypack.model.Application;

import com.lti.mypack.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService{

	@Autowired
	ApplicationRepository appRepo;
	@Override
	public List<Application> getApplication() {
		
		return appRepo.findAll();
	}

	@Override
	public Application addApplication(Application application) {
		return appRepo.save(application);
		
	}

	@Override
	public boolean deleteApp(int applicationid) {

		appRepo.deleteById(applicationid);
		return true;	
	}

	@Override
	public Application findApplication(int applicationid) {
		
		return appRepo.findById(applicationid).get();
	}

	@Override
	public  Application updateApplication(Application application) {
		Application newapp=appRepo.findById(application.getApplicationid()).get();
		newapp.setLoanstatus("Approved");
		return appRepo.save(newapp);
		 
	}

}
