package com.cdse.service.translator;

import com.cdse.domain.Person;
import com.cdse.domain.Role;
import com.cdse.dto.PersonDto;
import com.cdse.lookup.PersonLookup;
import com.cdse.lookup.PersonLookup_Service;

public class PersonTranslator implements CdseTranslator<Person, PersonDto>{

	@Override
	public void translateEntityToDto(Person inPerson, PersonDto inDto) {
		inDto.setFirstName(inPerson.getFirstName());
		inDto.setLastName(inPerson.getLastName());
		inDto.setPhotoPart(inPerson.getPhotoPart());
		for (Role role : inPerson.getRoles()) {
			inDto.getRoleNames().add(role.getRoleName());
		}
		
		PersonLookup_Service personLookupService = new PersonLookup_Service();
		PersonLookup personLookup = personLookupService.getPersonLookupPort();
		@SuppressWarnings("unused")
		String phoneNumber = personLookup.getPhoneNumber(inPerson.getLastName());
	}
	
	@Override
	public void translateDtoToEntity(Person inPerson, PersonDto inDto) {

		if (inDto.getPersonId() != null) {
			inPerson.setPersonId(inDto.getId());
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
