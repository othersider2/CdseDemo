package com.cdse.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.CdseDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.EntityState;
import com.cdse.dto.CdseDto;

public abstract class CdseServiceAbstract<TDto extends CdseDto, TDom extends CdseEntity> implements CdseService<TDto> {

	@Autowired
	private CdseDao<TDom, TDto> entityDao;
	
	protected abstract TDom getDomObject();

	@Override
	@Transactional
	public void insert(TDto inDto) throws IOException {
		
		// create domain object
		TDom domainObject = getDomObject();
		
		// copy attributes from DTO to Domain object
		inDto.copyTo(domainObject);
		
		// set the state
		domainObject.setState(EntityState.NEW);
		
		// let the domain object(s) do the business logic without persistence
		domainObject.populate();
    	
    	// now that the domain object(s) have populated all attributes, persist the domain object(s) to the database
		getEntityDao().insert(domainObject);
	}

	@Override
	@Transactional
	public void insertOrUpdate(TDto inDto) throws IOException {
		
		// create domain object
		TDom domainObject = getDomObject();

		// copy attributes from DTO to Domain object
		inDto.copyTo(domainObject);
		
		domainObject.populate();
		
		getEntityDao().insertOrUpdate(domainObject);
	}

	@Override
	@Transactional
	public void update(String inQueryKey, TDto inDto) throws IOException {
		
		TDom oldEntity = getEntityDao().get(inQueryKey, getDomObject().getClass(), inDto);
		
		// copy attributes from DTO to Domain object
		inDto.copyTo(oldEntity);
		
		// set the state
		oldEntity.setState(EntityState.DIRTY);
		
		oldEntity.populate();
		getEntityDao().insertOrUpdate(oldEntity);
	}

	@Override
	@Transactional
	public void delete(TDto inDto) throws IOException {
		// create domain object
		TDom domainObject = getDomObject();

		inDto.copyTo(domainObject);
		getEntityDao().delete(domainObject);
	}

	@Override
	@Transactional
	public void get(String inQueryKey, TDto inDto) {

		TDom oldEntity = getEntityDao().get(inQueryKey, getDomObject().getClass(), inDto);
		inDto.copyFrom(oldEntity);
	}

	@Override
	@Transactional
	public List<TDto> getList(String inQueryKey, TDto inDto) {
		
		List<TDom> domainList = getEntityDao().getList(inQueryKey, getDomObject().getClass(), inDto);
		return null;
	}

	public CdseDao<TDom, TDto> getEntityDao() {
		return entityDao;
	}

	public void setEntityDao(CdseDao<TDom, TDto> entityDao) {
		this.entityDao = entityDao;
	}
}
