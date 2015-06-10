package com.cdse.service.write;

import java.io.IOException;
import java.util.List;

import com.cdse.dto.Identifiable;

public interface WriteService<TInDto extends Identifiable> {
	void execute(String inRequstMapping, TInDto inDto) throws IOException;
}
