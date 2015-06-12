package com.cdse.service.read;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.ReadDao;
import com.cdse.dto.Identifiable;
import com.cdse.translator.CdseTranslator;

public abstract class ReadServiceImpl<TSubject extends Identifiable, TInDto extends Identifiable, TOutDto> implements ReadService<TInDto, TOutDto> {

	private Map<String, ReadDao<TSubject, TInDto>> readDaoMap;

	private CdseTranslator<TSubject, TOutDto> translator;
	
	protected abstract TSubject getDomObject();

	protected abstract TOutDto getOutDto();

	@Override
	@Transactional
	public void execute(String inRequestMapping, TInDto inDto, Map<String, TOutDto> inOutDtoMap) throws IOException {
		ReadDao<TSubject, TInDto> readDao = getReadDaoMap().get(inRequestMapping);
		List<TSubject> subjectList = readDao.execute(getDomObject(), inDto);
		
		for (TSubject subject : subjectList) {
			TOutDto outDto = null;
			if (inOutDtoMap.containsKey(subject.getId())) {
				outDto = inOutDtoMap.get(subject.getId());
			} else {
				outDto = getOutDto();
			}
			getTranslator().translateEntityToDto(subject, outDto);
			inOutDtoMap.put(subject.getId(), outDto);
		}	
	}

	private CdseTranslator<TSubject, TOutDto> getTranslator() {
		return translator;
	}

	public void setTranslator(CdseTranslator<TSubject, TOutDto> translator) {
		this.translator = translator;
	}

	public Map<String, ReadDao<TSubject, TInDto>> getReadDaoMap() {
		return readDaoMap;
	}

	public void setReadDaoMap(Map<String, ReadDao<TSubject, TInDto>> readDaoMap) {
		this.readDaoMap = readDaoMap;
	}

}
