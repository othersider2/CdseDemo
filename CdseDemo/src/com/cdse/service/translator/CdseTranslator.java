package com.cdse.service.translator;

import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;

public interface CdseTranslator<TDom extends CdseEntity, TDto extends CdseDto> {
	void translateEntityToDto(TDom inDom, TDto inDto);
	void translateDtoToEntity(TDom inDom, TDto inDto);
}
