package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
import com.cdse.dto.PersonDto;

@Repository
public class GetPersonUsingNameQueryImpl implements CdseQuery<Person, PersonDto> {

	@Override
	public List<Person> execute(SessionFactory inSessionFactory, Person inPrototype, PersonDto inPersonDto) {
		@SuppressWarnings("unchecked")
		List<Person> persons = inSessionFactory.getCurrentSession().createQuery(
			    "from Persons as person where person.lastName = ?")
			    .setString(0, inPersonDto.getLastName())
			    .list();
		return persons;
	}

}
