package com.csquare.ums.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserMasterDTO {

	

	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String password;
	private List<Long> roles;
	private boolean isEnabled;
	
	private Set<UserRoleDTO> userRoleDTOSet = new HashSet<>(0);
	
	private List<String> userRoles = new ArrayList<>();

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}



	public Set<UserRoleDTO> getUserRoleDTOSet() {
		return userRoleDTOSet;
	}

	public void setUserRoleDTOSet(Set<UserRoleDTO> userRoleDTOSet) {
		this.userRoleDTOSet = userRoleDTOSet;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Long> getRoles() {
		return roles;
	}

	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}



	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
