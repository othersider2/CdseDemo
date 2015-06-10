package com.cdse.translator.rest;

import com.cdse.domain.Person;
import com.cdse.dto.PersonDto;
import com.cdse.translator.CdseTranslator;

public class PersonTranslator implements CdseTranslator<Person, PersonDto>{

	@Override
	public void translateEntityToDto(Person inPerson, PersonDto inDto) {
		
	 
	}
	
	@Override
	public void translateDtoToEntity(Person inPerson, PersonDto inDto) {

	}
}
