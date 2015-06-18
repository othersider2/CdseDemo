package com.cdse.dao.db;

import java.io.IOException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdse.dao.WriteDao;
import com.cdse.domain.CdseEntity;

public class DbUpdateDao<TDom extends CdseEntity> implements WriteDao<TDom>{

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void execute(TDom inDom) throws IOException {
		
		// attach passed detached object to the current session and persist changes.  Upon completion of 
		// the update operation, the object state is no longer detached and changes to a persistent state.
		sessionFactory.getCurrentSession().update(inDom);
	}
}
