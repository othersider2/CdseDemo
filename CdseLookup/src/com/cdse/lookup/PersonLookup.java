package com.cdse.lookup;

import javax.jws.*;

@WebService(serviceName="PersonLookup")
public class PersonLookup {

	@WebMethod
	public String getPhoneNumber(String inName) {
		return "555-555-5555";
	}
}
