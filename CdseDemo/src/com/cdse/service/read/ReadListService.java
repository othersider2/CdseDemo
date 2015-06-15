package com.cdse.service.read;

import java.io.IOException;
import java.util.Map;

public interface ReadListService<TInDto, TOutDto> {
	void execute(String inRequestMapping, TInDto inDto, Map<String, TOutDto> inOutDtoList) throws IOException;
}
