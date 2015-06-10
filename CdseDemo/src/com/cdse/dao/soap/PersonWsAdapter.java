package com.cdse.dao.soap;

import net.lookup.person.PersonWS;

import com.cdse.dto.Identifiable;

public class PersonWsAdapter implements Identifiable{
	
	private PersonWS personWs;
	
	public String getPersonId() {
		return getPersonWs().getId();
	}
	public String getFirstName() {
		return getPersonWs().getFirstName();
	}
	public String getLastName() {
		return getPersonWs().getLastName();
	}
	@Override
	public String getId() {
		return this.getPersonId();
	}
	public String getPhoneNumber() {
		return getPersonWs().getPhoneNumber();
	}
	private PersonWS getPersonWs() {
		return personWs;
	}
	public void setPersonWs(PersonWS personWs) {
		this.personWs = personWs;
	}
}
