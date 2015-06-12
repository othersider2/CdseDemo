package com.cdse.dao.db;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.dao.ReadDao;
import com.cdse.domain.Person;
import com.cdse.dto.PersonDto;

@Repository
public class GetPersonUsingNameQueryImpl implements ReadDao<Person, PersonDto> {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<Person> execute(Person inPrototype, PersonDto inPersonDto) {
		@SuppressWarnings("unchecked")
		List<Person> persons = sessionFactory.getCurrentSession().createQuery(
			    "from Persons as person where person.lastName = ?")
			    .setString(0, inPersonDto.getLastName())
			    .list();
		return persons;
	}

}
