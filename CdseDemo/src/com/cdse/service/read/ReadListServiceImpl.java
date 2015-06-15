package com.cdse.service.read;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.CdseDao;
import com.cdse.dao.ReadListDao;
import com.cdse.dto.Identifiable;
import com.cdse.translator.CdseTranslator;

public abstract class ReadListServiceImpl<TSubject extends Identifiable, TInDto extends Identifiable, TOutDto> implements ReadListService<TInDto, TOutDto> {

	private CdseDao<TSubject, Identifiable> dao;

	private CdseTranslator<TSubject, TOutDto> translator;
	
	protected abstract TOutDto getOutDto();

	@Override
	@Transactional
	public void execute(String inRequestMapping, TInDto inDto, Map<String, TOutDto> inOutDtoMap) throws IOException {
		List<TSubject> subjectList = dao.getList(inRequestMapping, inDto);
		
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

	public CdseDao<TSubject, Identifiable> getDao() {
		return dao;
	}

	public void setDao(CdseDao<TSubject, Identifiable> dao) {
		this.dao = dao;
	}

}
