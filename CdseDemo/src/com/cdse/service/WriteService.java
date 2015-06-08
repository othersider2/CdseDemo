package com.cdse.service;

import java.io.IOException;
import java.util.List;

import com.cdse.dto.CdseDto;

public interface WriteService<TInDto extends CdseDto> {
	void execute(String inRequstMapping, TInDto inDto) throws IOException;
}
