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
		sessionFactory.getCurrentSession().saveOrUpdate(inDom);
	}
}
