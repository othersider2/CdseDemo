package com.cdse.translator.soap;

import javax.ws.rs.core.MediaType;

import net.lookup.person.PersonLookup;
import net.lookup.person.PersonLookup_Service;
import net.lookup.person.PersonWS;

import com.cdse.dao.soap.SoapPersonDto;
import com.cdse.domain.Person;
import com.cdse.domain.Role;
import com.cdse.dto.PersonDto;
import com.cdse.translator.CdseTranslator;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PersonTranslator implements CdseTranslator<SoapPersonDto, PersonDto>{

	@Override
	public void translateEntityToDto(SoapPersonDto inSoapPersonDto, PersonDto inDto) {
		inDto.setPhoneNumber(inSoapPersonDto.getPhoneNumber());
	}
	
	@Override
	public void translateDtoToEntity(SoapPersonDto inSoapPersonDto, PersonDto inDto) {

		inSoapPersonDto.setFirstName(inDto.getFirstName());
		inSoapPersonDto.setLastName(inDto.getLastName());
	}
}
