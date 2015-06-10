package com.cdse.translator.db;

import javax.ws.rs.core.MediaType;

import net.lookup.person.PersonLookup;
import net.lookup.person.PersonLookup_Service;

import com.cdse.domain.Person;
import com.cdse.domain.Role;
import com.cdse.dto.PersonDto;
import com.cdse.translator.CdseTranslator;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PersonTranslator implements CdseTranslator<Person, PersonDto>{

	@Override
	public void translateEntityToDto(Person inPerson, PersonDto inDto) {
		inDto.setFirstName(inPerson.getFirstName());
		inDto.setLastName(inPerson.getLastName());
		inDto.setPhotoPart(inPerson.getPhotoPart());
		for (Role role : inPerson.getRoles()) {
			inDto.getRoleNames().add(role.getRoleName());
		}
	}
	
	@Override
	public void translateDtoToEntity(Person inPerson, PersonDto inDto) {

		if (inDto.getPersonId() != null) {
			inPerson.setPersonId(Integer.parseInt(inDto.getId()));
		}
		inPerson.setFirstName(inDto.getFirstName());
		inPerson.setLastName(inDto.getLastName());
		inPerson.setPhotoPart(inDto.getPhotoPart());
		for (String roleName : inDto.getRoleNames()) {       
			
			Role role = new Role();
			role.setRoleName(roleName);
			inPerson.getRoles().add(role);
		}
	}
}
