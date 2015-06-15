package com.cdse.dao.db;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.dao.ReadListDao;
import com.cdse.domain.Person;
import com.cdse.dto.PersonDto;

@Repository
public class GetPersonUsingNameQueryImpl implements ReadListDao<Person, PersonDto> {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<Person> execute(PersonDto inPersonDto) {
		@SuppressWarnings("unchecked")
		List<Person> persons = sessionFactory.getCurrentSession().createQuery(
			    "from Person as person where person.id = ?")
			    .setString(0, inPersonDto.getId())
			    .list();
		return persons;
	}

}
