package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdse.domain.Person;

@Repository
public class GetPersonUsingNameQueryImpl implements CdseQuery<Person> {

	@Override
	public List<Person> execute(SessionFactory inSessionFactory, Person inSpec) {
		@SuppressWarnings("unchecked")
		List<Person> persons = inSessionFactory.getCurrentSession().createQuery(
			    "from Persons as person where person.lastName = ?")
			    .setString(0, inSpec.getLastName())
			    .list();
		return persons;
	}

}
