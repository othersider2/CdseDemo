package net.rest.person;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("person/{id}")
public class PersonRestService {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public PersonListContainer getXmlPersonInfo(@PathParam("id") int personId) {
		
		PersonRest personRest= new PersonRest();
		personRest.setPersonId(String.valueOf(personId));
		personRest.setPhoneNumber("999-999-9999");
		PersonListContainer outContainer = new PersonListContainer();
		outContainer.getPersonList().add(personRest);
		return outContainer;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PersonRest getJsonPersonInfo() {
		
		PersonRest personJSon = new PersonRest();
		personJSon.setPhoneNumber("999-999-9999");
		
		return personJSon;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtmlPersonInfo() {
		return "<html> " + "<title>" + "Phone Number" + "</title>" 
		+ "<body><h1>" + "PHONE_NUMBER - 555-555-5555" + "</body></h1>" + "</html>";
	}
	
	@PUT
	@Path("{personPhoneNumber}")
	public String updatePersonInfo(@PathParam("personPhoneNumber") String inPhoneNumber) {
		return "Done successfully";
	}
}
