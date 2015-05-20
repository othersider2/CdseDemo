package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;

public interface CdseQuery<T> {
	List<T> execute(SessionFactory inSessionFactory, T inSpec);
	
}
