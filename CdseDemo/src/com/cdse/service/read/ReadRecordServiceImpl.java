package com.cdse.service.read;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdse.dao.CdseDao;
import com.cdse.dao.ReadListDao;
import com.cdse.dto.Identifiable;
import com.cdse.translator.CdseTranslator;

public class ReadRecordServiceImpl<TSubject extends Identifiable, TInDto extends Identifiable, TOutDto> implements ReadRecordService<TInDto, TOutDto> {

	private CdseDao<TSubject, Identifiable> dao;

	private CdseTranslator<TSubject, TOutDto> translator;
	
	@Override
	@Transactional
	public void execute(String inRequestMapping, TInDto inDto, TOutDto inOutDto) throws IOException {
		TSubject subject = dao.get(inRequestMapping, inDto);
		getTranslator().translateEntityToDto(subject, inOutDto);
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
