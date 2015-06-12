package com.cdse.translator.rest;

import com.cdse.dao.rest.PersonRestAdapter;
import com.cdse.domain.Person;
import com.cdse.dto.PersonDto;
import com.cdse.translator.CdseTranslator;

public class PersonTranslator implements CdseTranslator<PersonRestAdapter, PersonDto>{

	@Override
	public void translateEntityToDto(PersonRestAdapter inPerson, PersonDto inDto) {
		inDto.setPhoneNumber(inDto.getPhoneNumber());
	 
	}
	
	@Override
	public void translateDtoToEntity(PersonRestAdapter inPerson, PersonDto inDto) {

	}
}
