package com.cdse.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.ReadDao;
import com.cdse.dao.db.DbReadDao;
import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;
import com.cdse.service.translator.CdseTranslator;

public abstract class WsReadServiceImpl<TResource, TDto extends CdseDto, TOutDto> implements ReadService<TDto, TOutDto> {

	private Map<String, ReadDao<TResource, TDto>> readDaoMap;

	private CdseTranslator<TResource, TOutDto> translator;
//	
	protected abstract TResource getDomObject();
//
	protected abstract TOutDto getOutDto();

	@Override
	@Transactional
	public void execute(String inRequestMapping, TDto inDto, List<TOutDto> inOutDtoList) throws IOException {
		// TODO Auto-generated method stub
		ReadDao<TResource, TDto> readDao = getReadDaoMap().get(inRequestMapping);
		List<TResource> entityList = readDao.execute(null, inDto);
		
		TOutDto outDto = getOutDto();
		getTranslator().translateEntityToDto(entityList.get(0), outDto);
		inOutDtoList.add(outDto);
	}

//	private CdseTranslator<TResource, TDto> getTranslator() {
//		return translator;
//	}
//
//	public void setTranslator(CdseTranslator<TResource, TDto> translator) {
//		this.translator = translator;
//	}
//
	public Map<String, ReadDao<TResource, TDto>> getReadDaoMap() {
		return readDaoMap;
	}

	public void setReadDaoMap(Map<String, ReadDao<TResource, TDto>> readDaoMap) {
		this.readDaoMap = readDaoMap;
	}

	public CdseTranslator<TResource, TOutDto> getTranslator() {
		return translator;
	}

	public void setTranslator(CdseTranslator<TResource, TOutDto> translator) {
		this.translator = translator;
	}

}
