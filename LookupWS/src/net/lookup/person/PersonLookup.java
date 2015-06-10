package net.lookup.person;

import javax.jws.*;

@WebService(serviceName="PersonLookup")
public class PersonLookup {

	@WebMethod
	public PersonListContainer getPersonWS(String inId) {
		PersonWS personWs= new PersonWS();
		personWs.setId(inId);
		personWs.setPhoneNumber("555-555-5555");
		PersonListContainer outContainer = new PersonListContainer();
		outContainer.getPersonList().add(personWs);
		return outContainer;
	}
}
