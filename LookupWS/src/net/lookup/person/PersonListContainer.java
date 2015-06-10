package net.lookup.person;

import java.util.ArrayList;
import java.util.List;

public class PersonListContainer {
	private List<PersonWS> responseList = new ArrayList<PersonWS>();

	public List<PersonWS> getPersonList() {
		return responseList;
	}

	public void setPersonList(List<PersonWS> response) {
		this.responseList = response;
	}
	
}
