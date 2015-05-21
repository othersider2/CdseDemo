package com.cdse.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;

@Repository
public class LoadEntity<T extends CdseEntity> implements CdseQuery<T> {


	@SuppressWarnings("unchecked")
	@Override
	public List<T> execute(SessionFactory inSessionFactory, T inSpec) {
		List<T> outList = new ArrayList<T>();
		outList.add((T) inSessionFactory.getCurrentSession().get(inSpec.getClass(), inSpec.getId()));
		return outList;
	}

}
