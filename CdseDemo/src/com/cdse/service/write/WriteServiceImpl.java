package com.cdse.service.write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.CdseDao;
import com.cdse.dao.WriteDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.EntityState;
import com.cdse.dto.Identifiable;
import com.cdse.translator.CdseTranslator;

public abstract class WriteServiceImpl<TDom extends CdseEntity, TInDto extends Identifiable> implements WriteService<TInDto> {

	private CdseDao<TDom, Identifiable> dao;

	private CdseTranslator<TDom, TInDto> translator;
	
	protected abstract TDom getDomObject();

	@Override
	@Transactional
	public void execute(String inRequestMapping, TInDto inDto) throws IOException {
		// create domain object
		TDom domainObject = getDomObject();

		// copy attributes from DTO to Domain object
		getTranslator().translateDtoToEntity(domainObject, inDto);
		
		List<String> dozerMappingList = new ArrayList<String>();
		dozerMappingList.add("dozerMapping.xml");
		Mapper mapper = new DozerBeanMapper();
		mapper.map(inDto, domainObject);
		
		// set the state
		domainObject.setState(EntityState.NEW);
		
		// let the domain object(s) do the business logic without persistence
		domainObject.populate();
		
		dao.write(inRequestMapping, domainObject);
		
	}

	private CdseTranslator<TDom, TInDto> getTranslator() {
		return translator;
	}

	public void setTranslator(CdseTranslator<TDom, TInDto> translator) {
		this.translator = translator;
	}

	public CdseDao<TDom, Identifiable> getDao() {
		return dao;
	}

	public void setDao(CdseDao<TDom, Identifiable> dao) {
		this.dao = dao;
	}
}
