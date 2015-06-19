package com.cdse.dao.soap;

import java.util.ArrayList;
import java.util.List;

import net.lookup.person.PersonListContainer;
import net.lookup.person.PersonLookup;
import net.lookup.person.PersonLookup_Service;
import net.lookup.person.PersonWS;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.dao.ReadListDao;
import com.cdse.dto.PersonDto;

public class SoapGetPersonUsingId implements ReadListDao<PersonWsAdapter, PersonDto> {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<PersonWsAdapter> execute(PersonDto inDto) {
		PersonLookup_Service personLookupService = new PersonLookup_Service();
		PersonLookup personLookup = personLookupService.getPersonLookupPort();
		PersonListContainer personListContainer = personLookup.getPersonWS(inDto.getId());
		
		List<PersonWsAdapter> outList = new ArrayList<PersonWsAdapter>();
		for (PersonWS personWs : personListContainer.getPersonList()) {
			PersonWsAdapter soapPersonDto = new PersonWsAdapter();
			soapPersonDto.setPersonWs(personWs);
			outList.add(soapPersonDto);
		}
		
		return outList;
	}

}
