package com.cdse.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
import com.cdse.domain.Role;

public class PersonDto implements CdseDto{

	private String personId;
	
	private String firstName;
	
	private String lastName;

	private MultipartFile photoPart;
	
    private Set<String> roleNames = new HashSet<String>();
    
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
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
	public MultipartFile getPhotoPart() {
		return photoPart;
	}
	public void setPhotoPart(MultipartFile photoPart) {
		this.photoPart = photoPart;
	}
	
	public Set<String> getRoleNames() {
		return roleNames;
	}
	public void setRoles(Set<String> roleNames) {
		this.roleNames = roleNames;
	}
	@Override
	public int getId() {
		return Integer.parseInt(this.getPersonId());
	}
}
