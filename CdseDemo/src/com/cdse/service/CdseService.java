package com.cdse.service;

import java.io.IOException;
import java.util.List;

import com.cdse.dto.Identifiable;

public interface CdseService<TinDto extends Identifiable, TOutDto> {

	public abstract void write(String inRequstMapping, TinDto inInDto)
			throws IOException;

	public abstract TOutDto get(String inRequstMapping, TinDto inInDto);

	public abstract List<TOutDto> getList(String inRequstMapping, TinDto inInDto);

}