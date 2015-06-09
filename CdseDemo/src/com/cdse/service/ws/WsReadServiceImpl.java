package com.cdse.service.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.ReadDao;
import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;
import com.cdse.service.ReadService;
import com.cdse.translator.CdseTranslator;

public abstract class WsReadServiceImpl<TResource, TInDto extends CdseDto, TOutDto extends CdseDto> implements ReadService<TInDto, TOutDto> {

	private Map<String, ReadDao<TResource, TOutDto>> readDaoMap;

	private CdseTranslator<TResource, TOutDto> translator;
//	
	protected abstract TResource getDomObject();
//
	protected abstract TOutDto getOutDto();

	@Override
	@Transactional
	public void execute(String inRequestMapping, TInDto inDto, List<TOutDto> inOutDtoList) throws IOException {
		// TODO Auto-generated method stub
		
		for (TOutDto outDto : inOutDtoList) {
			ReadDao<TResource, TOutDto> readDao = getReadDaoMap().get(inRequestMapping);
			List<TResource> entityList = readDao.execute(null, outDto);
			getTranslator().translateEntityToDto(entityList.get(0), outDto);
		}	
	}

//	private CdseTranslator<TResource, TInDto> getTranslator() {
//		return translator;
//	}
//
//	public void setTranslator(CdseTranslator<TResource, TInDto> translator) {
//		this.translator = translator;
//	}
//
	public Map<String, ReadDao<TResource, TOutDto>> getReadDaoMap() {
		return readDaoMap;
	}

	public void setReadDaoMap(Map<String, ReadDao<TResource, TOutDto>> readDaoMap) {
		this.readDaoMap = readDaoMap;
	}

	public CdseTranslator<TResource, TOutDto> getTranslator() {
		return translator;
	}

	public void setTranslator(CdseTranslator<TResource, TOutDto> translator) {
		this.translator = translator;
	}

}
