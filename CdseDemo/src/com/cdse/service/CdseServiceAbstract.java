package com.cdse.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.CdseDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.EntityState;
import com.cdse.dto.CdseDto;
import com.cdse.service.translator.CdseTranslator;

public abstract class CdseServiceAbstract<TDom extends CdseEntity, TDto extends CdseDto> implements CdseService<TDto> {

	@Autowired
	private CdseDao<TDom, TDto> entityDao;
	
	private CdseTranslator<TDom, TDto> translator;
	
	protected abstract TDom getDomObject();

	@Override
	@Transactional
	public void insert(TDto inDto) throws IOException {
		
		// create domain object
		TDom domainObject = getDomObject();
		
		// copy attributes from DTO to Domain object
		getTranslator().translateDtoToEntity(domainObject, inDto);
		
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
		getTranslator().translateDtoToEntity(domainObject, inDto);
		
		domainObject.populate();
		
		getEntityDao().insertOrUpdate(domainObject);
	}

	@Override
	@Transactional
	public void update(String inQueryKey, TDto inDto) throws IOException {
		
		TDom oldEntity = getEntityDao().get(inQueryKey, getDomObject(), inDto);
		
		// copy attributes from DTO to Domain object
		getTranslator().translateDtoToEntity(oldEntity, inDto);
		
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

		getTranslator().translateDtoToEntity(domainObject, inDto);
		getEntityDao().delete(domainObject);
	}

	@Override
	@Transactional
	public void get(String inQueryKey, TDto inDto) {

		TDom oldEntity = getEntityDao().get(inQueryKey, getDomObject(), inDto);
		getTranslator().translateEntityToDto(oldEntity, inDto);
	}

	@Override
	@Transactional
	public List<TDto> getList(String inQueryKey, TDto inDto) {
		
		List<TDom> domainList = getEntityDao().getList(inQueryKey, getDomObject(), inDto);
		return null;
	}

	public CdseDao<TDom, TDto> getEntityDao() {
		return entityDao;
	}

	public void setEntityDao(CdseDao<TDom, TDto> entityDao) {
		this.entityDao = entityDao;
	}

	private CdseTranslator<TDom, TDto> getTranslator() {
		return translator;
	}

	public void setTranslator(CdseTranslator<TDom, TDto> translator) {
		this.translator = translator;
	}
}
