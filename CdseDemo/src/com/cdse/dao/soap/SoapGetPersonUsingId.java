package com.cdse.dao.soap;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import net.lookup.person.PersonListContainer;
import net.lookup.person.PersonLookup;
import net.lookup.person.PersonLookup_Service;
import net.lookup.person.PersonWS;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.dao.ReadDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
import com.cdse.dto.Identifiable;
import com.cdse.dto.PersonDto;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Repository
public class SoapGetPersonUsingId implements ReadDao<PersonWsAdapter, PersonDto> {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<PersonWsAdapter> execute(PersonWsAdapter inPrototype, PersonDto inDto) {
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
