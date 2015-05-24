package com.cdse.service;

import com.cdse.domain.Person;
import com.cdse.dto.CdseDto;

public class PersonService<TDto extends CdseDto> extends CdseServiceAbstract<TDto, Person> {
	
	@Override
	protected Person getDomObject() {
		// TODO Auto-generated method stub
		return new Person();
	}

	@Override
	protected Class<Person> getDomClass() {
		// TODO Auto-generated method stub
		return Person.class;
	}
}
