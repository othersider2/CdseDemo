package com.cdse.service.translator;

public interface CdseTranslator<TResource, TOutDto> {
	void translateEntityToDto(TResource inResource, TOutDto inOutDto);
	void translateDtoToEntity(TResource inResource, TOutDto inOutDto);
}
