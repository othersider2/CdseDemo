package net.lookup.person;

import javax.jws.*;

@WebService(serviceName="PersonLookup")
public class PersonLookup {

	@WebMethod
	public PersonWS getPersonWS(String inName) {
		PersonWS personWs= new PersonWS();
		personWs.setPhoneNumber("555-555-5555");
		return personWs;
	}
}
