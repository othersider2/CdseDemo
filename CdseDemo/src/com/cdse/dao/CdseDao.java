package com.cdse.dao;

import java.io.IOException;
import java.util.List;

import com.cdse.dto.Identifiable;

public interface CdseDao<TResource, TInDto extends Identifiable> {

	public abstract void write(String inRequestMapping, TResource inResource)
			throws IOException;

	public abstract TResource get(String inRequestMapping,
			TResource inPrototype, TInDto inInDto) throws IOException;

	public abstract List<TResource> getList(String inRequestMapping,
			TResource inPrototype, TInDto inInDto) throws IOException;

}