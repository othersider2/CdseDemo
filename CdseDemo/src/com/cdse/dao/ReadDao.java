package com.cdse.dao;

import java.io.IOException;
import java.util.List;

import com.cdse.dto.Identifiable;

public interface ReadDao<TResource, TInDto extends Identifiable> {
	List<TResource> execute(TResource inResource, TInDto inInDto) throws IOException;
}
