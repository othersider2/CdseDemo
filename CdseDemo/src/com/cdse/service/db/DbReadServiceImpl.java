package com.cdse.service.db;

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

public abstract class DbReadServiceImpl<TDom, TInDto extends CdseDto, TOutDto> implements ReadService<TInDto, TOutDto> {

	private Map<String, ReadDao<TDom, TInDto>> readDaoMap;

	private CdseTranslator<TDom, TOutDto> translator;
	
	protected abstract TDom getDomObject();

	protected abstract TOutDto getOutDto();

	@Override
	@Transactional
	public void execute(String inRequestMapping, TInDto inDto, List<TOutDto> inOutDtoList) throws IOException {
		ReadDao<TDom, TInDto> readDao = getReadDaoMap().get(inRequestMapping);
		List<TDom> entityList = readDao.execute(getDomObject(), inDto);
		
		for (TDom entity : entityList) {
			TOutDto outDto = getOutDto();
			getTranslator().translateEntityToDto(entity, outDto);
			inOutDtoList.add(outDto);
		}	
	}

	private CdseTranslator<TDom, TOutDto> getTranslator() {
		return translator;
	}

	public void setTranslator(CdseTranslator<TDom, TOutDto> translator) {
		this.translator = translator;
	}

	public Map<String, ReadDao<TDom, TInDto>> getReadDaoMap() {
		return readDaoMap;
	}

	public void setReadDaoMap(Map<String, ReadDao<TDom, TInDto>> readDaoMap) {
		this.readDaoMap = readDaoMap;
	}

}
