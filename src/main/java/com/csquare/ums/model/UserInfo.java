package com.csquare.ums.model;

import org.springframework.security.core.userdetails.User;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;


public class UserInfo extends User{
	
	private UserMaster user;
		
	public UserInfo(String userName, String password, UserMaster user, List<GrantedAuthority> authorities) {
		super(userName, password, authorities);
		this.user = user;
	}
	
//	public UserInfo(String userName, String password, UserMaster user, List<GrantedAuthority> authorities,HierarchyRelation company) {
//		super(userName, password, authorities);
//		this.user = user;
//	}

	public UserMaster getUser() {
		return user;
	}


}
