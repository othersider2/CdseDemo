package com.cdse.dao;

import java.io.IOException;
import java.util.List;

import com.cdse.domain.CdseEntity;
import com.cdse.dto.Identifiable;

public interface ReadDao<TResource, TDto extends Identifiable> {
	List<TResource> execute(TResource inResource, TDto inDto) throws IOException;
}
