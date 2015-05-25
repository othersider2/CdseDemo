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
	public <TDom extends CdseEntity> void copyTo(TDom inPerson) {
		Person person = (Person)inPerson;
		if (this.getPersonId() != null) {
			person.setPersonId(this.getId());
		}
		person.setFirstName(this.getFirstName());
		person.setLastName(this.getLastName());
		person.setPhotoPart(this.getPhotoPart());
		for (String roleName : this.getRoleNames()) {       
			
			Role role = new Role();
			role.setRoleName(roleName);
			person.getRoles().add(role);
		}
	}
	
	@Override
	public <TDom extends CdseEntity> void copyFrom(TDom inPerson) {
		Person person = (Person)inPerson;
		this.setFirstName(person.getFirstName());
		this.setLastName(person.getLastName());
		this.setPhotoPart(person.getPhotoPart());
		for (Role role : person.getRoles()) {
			this.getRoleNames().add(role.getRoleName());
		}

	}
	@Override
	public int getId() {
		return Integer.parseInt(this.getPersonId());
	}
}
