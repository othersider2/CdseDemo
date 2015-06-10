package com.cdse.service.write;

import java.io.IOException;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.db.WriteDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.EntityState;
import com.cdse.dto.Identifiable;
import com.cdse.translator.CdseTranslator;

public abstract class WriteServiceImpl<TDom extends CdseEntity, TInDto extends Identifiable> implements WriteService<TInDto> {

	private Map<String, WriteDao<TDom>> writeDaoMap;

	private CdseTranslator<TDom, TInDto> translator;
	
	protected abstract TDom getDomObject();

	@Override
	@Transactional
	public void execute(String inRequestMapping, TInDto inDto) throws IOException {
		// create domain object
		TDom domainObject = getDomObject();

		// copy attributes from DTO to Domain object
		getTranslator().translateDtoToEntity(domainObject, inDto);
		
		// set the state
		domainObject.setState(EntityState.NEW);
		
		// let the domain object(s) do the business logic without persistence
		domainObject.populate();
		
		WriteDao<TDom> writeDao = getWriteDaoMap().get(inRequestMapping);
		writeDao.execute(domainObject);
		
	}

	private CdseTranslator<TDom, TInDto> getTranslator() {
		return translator;
	}

	public void setTranslator(CdseTranslator<TDom, TInDto> translator) {
		this.translator = translator;
	}

	public Map<String, WriteDao<TDom>> getWriteDaoMap() {
		return writeDaoMap;
	}

	public void setWriteDaoMap(Map<String, WriteDao<TDom>> writeDaoMap) {
		this.writeDaoMap = writeDaoMap;
	}

}
