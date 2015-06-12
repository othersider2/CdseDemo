package net.rest.person;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonListContainer {
	private List<PersonRest> responseList = new ArrayList<PersonRest>();

	public List<PersonRest> getPersonList() {
		return responseList;
	}

	public void setPersonList(List<PersonRest> response) {
		this.responseList = response;
	}
	
}
