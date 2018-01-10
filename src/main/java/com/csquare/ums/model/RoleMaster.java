package com.csquare.ums.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * RoleMaster
 */
@Entity
@Table(name = "role_master", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "roleId")
public class RoleMaster implements java.io.Serializable {

	private long roleId;
	private String roleName;
	private String displayName;
	private Character supervisor;
	private Character addRec;
	private Character modifyRec;
	private Character deleteRec;
	private Character viewRec;
	private Character printRec;
	
	//private Set<MenuRole> menuRoles = new HashSet<>();
	
	public RoleMaster() {
	}

	public RoleMaster(long roleId) {
		this.roleId = roleId;
	}

	public RoleMaster(long roleId, String roleName, Character supervisor, Character addRec, Character modifyRec,
			Character deleteRec, Character viewRec, Character printRec) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.supervisor = supervisor;
		this.addRec = addRec;
		this.modifyRec = modifyRec;
		this.deleteRec = deleteRec;
		this.viewRec = viewRec;
		this.printRec = printRec;
		
	}

	@Id
	@Column(name = "role_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "supervisor", length = 1)
	public Character getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(Character supervisor) {
		this.supervisor = supervisor;
	}

	@Column(name = "add_rec", length = 1)
	public Character getAddRec() {
		return this.addRec;
	}

	public void setAddRec(Character addRec) {
		this.addRec = addRec;
	}

	@Column(name = "modify_rec", length = 1)
	public Character getModifyRec() {
		return this.modifyRec;
	}

	public void setModifyRec(Character modifyRec) {
		this.modifyRec = modifyRec;
	}

	@Column(name = "delete_rec", length = 1)
	public Character getDeleteRec() {
		return this.deleteRec;
	}

	public void setDeleteRec(Character deleteRec) {
		this.deleteRec = deleteRec;
	}

	@Column(name = "view_rec", length = 1)
	public Character getViewRec() {
		return this.viewRec;
	}

	public void setViewRec(Character viewRec) {
		this.viewRec = viewRec;
	}

	@Column(name = "print_rec", length = 1)
	public Character getPrintRec() {
		return this.printRec;
	}

	public void setPrintRec(Character printRec) {
		this.printRec = printRec;
	}

	@Column(name = "display_name", length = 50)
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	
	
		
}
