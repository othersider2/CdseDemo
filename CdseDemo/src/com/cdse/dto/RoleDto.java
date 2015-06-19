package com.cdse.dto;

public class RoleDto implements Identifiable {
	
	private Integer roleId;
	
	private String roleName;
		
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String firstName) {
		this.roleName = firstName;
	}

	public String getId() {
		return roleId.toString();
	}
}
