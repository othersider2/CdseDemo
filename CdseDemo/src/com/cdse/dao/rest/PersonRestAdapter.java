package com.cdse.dao.rest;

import net.lookup.person.rest.PersonRest;

import com.cdse.dto.Identifiable;

public class PersonRestAdapter implements Identifiable{
	
	private PersonRest personRest;
	
	public String getPersonId() {
		return getPersonRest().getPersonId();
	}
	public String getFirstName() {
		return getPersonRest().getFirstName();
	}
	public String getLastName() {
		return getPersonRest().getLastName();
	}
	@Override
	public String getId() {
		return this.getPersonId();
	}
	public String getPhoneNumber() {
		return getPersonRest().getPhoneNumber();
	}
	private PersonRest getPersonRest() {
		return personRest;
	}
	public void setPersonRest(PersonRest personRest) {
		this.personRest = personRest;
	}
}
