package com.cdse.service.read;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.cdse.dto.Identifiable;

public interface ReadService<TInDto, TOutDto> {
	void execute(String inRequestMapping, TInDto inDto, Map<String, TOutDto> inOutDtoList) throws IOException;
}
