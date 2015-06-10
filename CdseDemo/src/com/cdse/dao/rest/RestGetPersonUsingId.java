package com.cdse.dao.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.dao.ReadDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
import com.cdse.dto.Identifiable;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Repository
public class RestGetPersonUsingId<TResource, TDto extends Identifiable> implements ReadDao<TResource, TDto> {

	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TResource> execute(TResource inPrototype, TDto inDto) {
		Person outPerson = new Person();
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client
					   .resource("http://localhost:7001/RestWS/rest/person");
					 
			ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN)
	                   .get(ClientResponse.class);
	 
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
	 
//			outPerson.setPhoneNumber(response.getEntity(String.class));
//	 
//			System.out.println("Output from Server .... \n");
//			System.out.println(outPerson.getPhoneNumber());
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
			 
		  }
		  return null;
	}

}
