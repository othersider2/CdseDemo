package com.cdse.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

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
	public <TDom> TDom copyTo() {
		Person outPerson = new Person();
		if (this.getPersonId() != null) {
			outPerson.setPersonId(this.getId());
		}
		outPerson.setFirstName(this.getFirstName());
		outPerson.setLastName(this.getLastName());
		outPerson.setPhotoPart(this.getPhotoPart());
		for (String roleName : this.getRoleNames()) {
			Role role = new Role();
			role.setRoleName(roleName);
			outPerson.getRoles().add(role);
		}
		
		return (TDom) outPerson;
	}
	@Override
	public <TDom> void copyTo(TDom inDom) {
		Person person = (Person)inDom;
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
	public <TDom> void copyFrom(TDom inDom) {
		Person person = (Person)inDom;
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
	
	 @SuppressWarnings("unchecked")
	public <TDom> Class<TDom> getClassType() {
		Person person = new Person();
		return (Class<TDom>) person.getClass();
	}
	   
}
