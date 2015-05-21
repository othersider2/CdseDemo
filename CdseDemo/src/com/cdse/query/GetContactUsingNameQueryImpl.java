package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdse.domain.Contact;

@Repository
public class GetContactUsingNameQueryImpl implements CdseQuery<Contact> {

	@Override
	public List<Contact> execute(SessionFactory inSessionFactory, Contact inSpec) {
		@SuppressWarnings("unchecked")
		List<Contact> contacts = inSessionFactory.getCurrentSession().createQuery(
			    "from Contacts as contact where contact.lastName = ?")
			    .setString(0, inSpec.getLastName())
			    .list();
		return contacts;
	}

}
