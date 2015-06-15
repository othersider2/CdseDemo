package com.cdse.service.read;

import java.io.IOException;
import java.util.Map;

public interface ReadRecordService<TInDto, TOutDto> {
	void execute(String inRequestMapping, TInDto inDto, TOutDto inOutDto) throws IOException;
}
