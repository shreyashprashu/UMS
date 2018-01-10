package com.csquare.ums.dto;

import java.io.Serializable;

public class UserRoleDTO implements Serializable {
private static final long serialVersionUID = -2805262997819453259L;
	
	private Long id;
	
	private String roleName;
	
	private Long userRoleId;

	private String roleDescription;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

}
