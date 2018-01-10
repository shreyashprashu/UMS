package com.csquare.ums;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.csquare.ums.dao.UserMasterRepository;
import com.csquare.ums.model.UserMaster;


@Component
public class InitialData implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;
	
	@Autowired
	private UserMasterRepository userMasterRepository;
	

//	
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		 if (alreadySetup) {
	            return;
		 }
		
	     //setup default user
		 if(userMasterRepository.findAll().isEmpty()) {
			 setupUsers();
		 }
		
		 
		 alreadySetup = true;
	}	
		
	
  
	
	public void setupRoles() {
		
	}
	
	public void setupUsers() {
		UserMaster userMaster = new UserMaster();
		userMaster.setUsername("admin");
		userMaster.setPassword("csquare");
		userMasterRepository.save(userMaster);
		
	}
	
	
	

}
