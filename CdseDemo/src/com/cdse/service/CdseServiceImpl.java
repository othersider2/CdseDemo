package com.cdse.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.CdseDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.EntityState;
import com.cdse.dto.CdseDto;

public class CdseServiceImpl<TDto extends CdseDto, TDom extends CdseEntity> implements CdseService<TDto> {

	@Autowired
	private CdseDao<TDto, TDom> entityDao;

	@Override
	@Transactional
	public void insert(TDto inDto) throws IOException {
		
		// copy attributes from DTO to Domain object
		TDom domainObject = inDto.copyTo();
		
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
		
		// copy attributes from DTO to Domain object
		@SuppressWarnings("unchecked")
		TDom domainObject = (TDom) inDto.copyTo();
		
		domainObject.populate();
		
		getEntityDao().insertOrUpdate(domainObject);
	}

	@Override
	@Transactional
	public void update(String inQueryKey, TDto inDto) throws IOException {
		
		TDom oldEntity = getEntityDao().get(inQueryKey, inDto);
		
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
		// set the state
		TDom domainObject = inDto.copyTo();
		getEntityDao().delete(domainObject);
	}

	@Override
	@Transactional
	public void get(String inQueryKey, TDto inDto) {
		TDom domainObject = getEntityDao().get(inQueryKey, inDto);
		inDto.copyFrom(domainObject);
	}

	@Override
	@Transactional
	public List<TDto> getList(String inQueryKey, TDto inDto) {
		List<TDom> domainList = getEntityDao().getList(inQueryKey, inDto);
		return null;
	}

	public CdseDao<TDto, TDom> getEntityDao() {
		return entityDao;
	}

	public void setEntityDao(CdseDao<TDto,TDom> entityDao) {
		this.entityDao = entityDao;
	}
}
