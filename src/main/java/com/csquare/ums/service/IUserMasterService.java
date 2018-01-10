package com.csquare.ums.service;

import java.util.List;

import com.csquare.ums.dto.AuthenticationRequest;
import com.csquare.ums.dto.UserMasterDTO;
import com.csquare.ums.model.UserMaster;

public interface IUserMasterService {
	public UserMaster authUser(AuthenticationRequest authRequest);
	
	public UserMaster addUpdateUser(UserMasterDTO user);
	
	public List<UserMaster> getAllUsers() ;
	
	public UserMaster getUserById(Long userId);
	
	public UserMaster getUserByUsername(String username);
	
	public UserMaster acitvateDeactivateUser(Long userId);

}
