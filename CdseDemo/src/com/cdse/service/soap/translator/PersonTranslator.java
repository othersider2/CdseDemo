package com.cdse.service.soap.translator;

import javax.ws.rs.core.MediaType;

import net.lookup.person.PersonLookup;
import net.lookup.person.PersonLookup_Service;
import net.lookup.person.PersonWS;

import com.cdse.domain.Person;
import com.cdse.domain.Role;
import com.cdse.dto.PersonDto;
import com.cdse.service.translator.CdseTranslator;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PersonTranslator implements CdseTranslator<PersonWS, PersonDto>{

	@Override
	public void translateEntityToDto(PersonWS inPersonWs, PersonDto inDto) {
		inDto.setPhoneNumber(inPersonWs.getPhoneNumber());
	}
	
	@Override
	public void translateDtoToEntity(PersonWS inPersonWs, PersonDto inDto) {

		inPersonWs.setFirstName(inDto.getFirstName());
		inPersonWs.setLastName(inDto.getLastName());
	}
}
