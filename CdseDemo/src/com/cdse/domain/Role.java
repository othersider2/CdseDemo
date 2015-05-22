package com.cdse.domain;

import java.io.IOException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@Override
	public <T> void copy(T inEntity) {
		Role inRole = (Role)inEntity;
		this.setRoleName(inRole.getRoleName());
	}

	@Override
	public int getId() {
		return getRoleId();
	}

}
