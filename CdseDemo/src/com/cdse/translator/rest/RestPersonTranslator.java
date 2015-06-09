package com.cdse.translator.rest;

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

public class RestPersonTranslator implements CdseTranslator<Person, PersonDto>{

	@Override
	public void translateEntityToDto(Person inPerson, PersonDto inDto) {
		
	 
	}
	
	@Override
	public void translateDtoToEntity(Person inPerson, PersonDto inDto) {

	}
}
