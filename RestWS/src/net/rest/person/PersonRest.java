package net.rest.person;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonRest {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtmlPersonInfo() {
		return "<html> " + "<title>" + "Phone Number" + "</title>" 
		+ "<body><h1>" + "PHONE_NUMBER - 555-555-5555" + "</body></h1>" + "</html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getXmlPersonInfo() {
		return "PHONE_NUMBER - 555-555-5555";
	}
	
	@PUT
	@Path("{personPhoneNumber}")
	public String updatePersonInfo(@PathParam("personPhoneNumber") String inPhoneNumber) {
		return "Done successfully";
	}
}
