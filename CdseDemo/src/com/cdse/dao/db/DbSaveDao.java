package com.cdse.dao.db;

import java.io.IOException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdse.dao.WriteDao;
import com.cdse.domain.CdseEntity;

public class DbSaveDao<TDom extends CdseEntity> implements WriteDao<TDom>{

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void execute(TDom inDom) throws IOException {
		
		// note:  saveOrUpdate saves changes for an object in a transient, persistent or detached state.  
		// use update to save changes of an object in a detached state only (record exists in database,
		// but corresponding object is not attached to the current session)
		sessionFactory.getCurrentSession().saveOrUpdate(inDom);
	}
}
