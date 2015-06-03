package com.cdse.query.rest;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
import com.cdse.dto.PersonDto;
import com.cdse.query.CdseQuery;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Repository
public class GetRestPersonInfoQueryImpl implements CdseQuery<WebResource, Person, PersonDto> {

	@Override
	public List<Person> execute(WebResource inWebResource, Person inPrototype, PersonDto inPersonDto) {
		
		Person outPerson = new Person();
		
		try {
			ClientResponse response = inWebResource.accept(MediaType.TEXT_PLAIN)
	                   .get(ClientResponse.class);
	 
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
	 
			outPerson.setPhoneNumber(response.getEntity(String.class));
	 
			System.out.println("Output from Server .... \n");
			System.out.println(outPerson.getPhoneNumber());
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
		return null;
	}

}
