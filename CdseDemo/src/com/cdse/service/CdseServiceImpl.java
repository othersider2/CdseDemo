package com.cdse.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.CdseDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.EntityState;

public class CdseServiceImpl<T extends CdseEntity> implements CdseService<T> {

	@Autowired
	private CdseDao<T> entityDao;

	@Override
	@Transactional
	public void insert(T inEntity) throws IOException {
		
		// set the state
		inEntity.setState(EntityState.NEW);
		
		// let the domain object(s) do the business logic without persistence
    	inEntity.populate();
    	
    	// now that the domain object(s) have populated all attributes, persist the domain object(s) to the database
		getEntityDao().insert(inEntity);
	}

	@Override
	@Transactional
	public void insertOrUpdate(T inEntity) throws IOException {
    	inEntity.populate();
		getEntityDao().insertOrUpdate(inEntity);
	}

	@Override
	@Transactional
	public T update(String inQueryKey, T inEntity) throws IOException {
		
		T oldEntity = getEntityDao().get(inQueryKey, inEntity);
		oldEntity.copy(inEntity);
		
		// set the state
		oldEntity.setState(EntityState.DIRTY);
		
		oldEntity.populate();
		getEntityDao().update(oldEntity);
		return oldEntity;
	}

	@Override
	@Transactional
	public void delete(T inEntity) throws IOException {
		// set the state
		inEntity.setState(EntityState.OLD);
		
		getEntityDao().delete(inEntity);
	}

	@Override
	@Transactional
	public T get(String inQueryKey, T inSpec) {
		return getEntityDao().get(inQueryKey, inSpec);
	}

	@Override
	@Transactional
	public List<T> getList(String inQueryKey, T inSpec) {
		return getEntityDao().getList(inQueryKey, inSpec);
	}

	public CdseDao<T> getEntityDao() {
		return entityDao;
	}

	public void setEntityDao(CdseDao<T> entityDao) {
		this.entityDao = entityDao;
	}
}
