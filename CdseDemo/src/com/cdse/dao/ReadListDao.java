package com.cdse.dao;

import java.io.IOException;
import java.util.List;

import com.cdse.dto.Identifiable;

public interface ReadListDao<TResource, TInDto extends Identifiable> {
	List<TResource> execute(TInDto inInDto) throws IOException;
}
