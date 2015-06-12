package com.cdse.dao.rest;

import java.util.ArrayList;
import java.util.List;

import net.lookup.person.PersonLookup;
import net.lookup.person.PersonLookup_Service;
import net.lookup.person.PersonWS;
import net.lookup.person.rest.PersonListContainer;
import net.lookup.person.rest.PersonRest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cdse.dao.ReadDao;
import com.cdse.dto.PersonDto;

@Repository
public class RestGetPersonUsingId implements ReadDao<PersonRestAdapter, PersonDto> {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<PersonRestAdapter> execute(PersonRestAdapter inPrototype, PersonDto inDto) {
		RestTemplate restTemplate = new RestTemplate();
		PersonListContainer personListContainer = restTemplate.getForObject("http://localhost:7001/RestWS/rest/person/" + inDto.getId(), PersonListContainer.class);
		
		List<PersonRestAdapter> outList = new ArrayList<PersonRestAdapter>();
		for (PersonRest personRest : personListContainer.getPersonList()) {
			PersonRestAdapter restPersonDto = new PersonRestAdapter();
			restPersonDto.setPersonRest(personRest);
			outList.add(restPersonDto);
		}
		
		return outList;
		
//		Person outPerson = new Person();
//		
//		try {
//			Client client = Client.create();
//			
//			WebResource webResource = client
//					   .resource("http://localhost:7001/RestWS/rest/person");
//					 
//			ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN)
//	                   .get(ClientResponse.class);
//	 
//			if (response.getStatus() != 200) {
//			   throw new RuntimeException("Failed : HTTP error code : "
//				+ response.getStatus());
//			}
//	 
//			outPerson.setPhoneNumber(response.getEntity(String.class));
//	 
//			System.out.println("Output from Server .... \n");
//			System.out.println(outPerson.getPhoneNumber());
//	 
//		  } catch (Exception e) {
//	 
//			e.printStackTrace();
//			 
//		  }
//		  return null;
	}

}
