package com.cdse.dao;

import java.io.IOException;
import java.util.List;

import com.cdse.dto.Identifiable;

public interface ReadRecordDao<TResource, TInDto extends Identifiable> {
	TResource execute(TInDto inInDto) throws IOException;
}
