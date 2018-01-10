package com.csquare.ums.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ums.model.UserMaster;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long>  {
	
	public UserMaster findUserMasterByUserName(String userName);
	
	
	public UserMaster findByUserNameAndPassword(String userName,String password);

}
	
	


