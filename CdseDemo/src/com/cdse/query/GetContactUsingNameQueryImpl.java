package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdse.domain.Contacts;

@Repository
public class GetContactUsingNameQueryImpl implements CdseQuery<Contacts> {

	@Override
	public List<Contacts> execute(SessionFactory inSessionFactory, Contacts inSpec) {
		@SuppressWarnings("unchecked")
		List<Contacts> contacts = inSessionFactory.getCurrentSession().createQuery(
			    "from Contacts as contact where contact.lastName = ?")
			    .setString(0, inSpec.getLastName())
			    .list();
		return contacts;
	}

}
