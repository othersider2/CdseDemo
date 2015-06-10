package com.cdse.translator.soap;

import com.cdse.dao.soap.PersonWsAdapter;
import com.cdse.dto.PersonDto;
import com.cdse.translator.CdseTranslator;

public class PersonTranslator implements CdseTranslator<PersonWsAdapter, PersonDto>{

	@Override
	public void translateEntityToDto(PersonWsAdapter inSoapPersonDto, PersonDto inDto) {
		inDto.setPhoneNumber(inSoapPersonDto.getPhoneNumber());
	}
	
	@Override
	public void translateDtoToEntity(PersonWsAdapter inSoapPersonDto, PersonDto inDto) {
	}
}
