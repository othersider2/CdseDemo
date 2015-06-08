package com.cdse.service;

import java.io.IOException;
import java.util.List;

import com.cdse.dto.CdseDto;

public interface ReadService<TInDto, TOutDto> {
	void execute(String inRequestMapping, TInDto inDto, List<TOutDto> inOutDtoList) throws IOException;
}
