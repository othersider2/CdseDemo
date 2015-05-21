package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cdse.domain.CdseEntity;

public interface CdseQuery<T extends CdseEntity> {
	List<T> execute(SessionFactory inSessionFactory, T inSpec);
	
}
