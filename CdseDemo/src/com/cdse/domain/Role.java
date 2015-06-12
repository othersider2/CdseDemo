package com.cdse.domain;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ROLE")
public class Role implements CdseEntity{
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

	@Id
	@GeneratedValue()
	private Integer roleId;
	
	private String roleName;
	
	@Transient
	private EntityState state;
	
	@Override
	public void populate() throws IOException {
        switch (getState()) {
        	
        case NEW:
        	break;        	
        case OLD:
        	break;   	
        case DIRTY:
        	break;
        default:
        	break;
        }
        
	}
	public EntityState getState() {
		return state;
	}
	@Override
	public void setState(EntityState state) {
		this.state = state;
	}
}
