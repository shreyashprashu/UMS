package com.csquare.ums.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ums.model.RoleMaster;

public interface RoleMasterRepository extends JpaRepository<RoleMaster, Long>{
	
	public RoleMaster findByRoleNameIgnoreCase(String roleName);

}
