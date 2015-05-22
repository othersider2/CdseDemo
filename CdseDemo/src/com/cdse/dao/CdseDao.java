package com.cdse.dao;

import java.io.IOException;
import java.util.List;

import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;

public interface CdseDao<TDto extends CdseDto, TDom extends CdseEntity> {

	void insert(TDom inEntity) throws IOException;
	void insertOrUpdate(TDom inEntity) throws IOException;
	void update(TDom inEntity) throws IOException;
	void delete(TDom inDom) throws IOException;
	TDom get(String inQueryKey, TDto inSpec);
	List<TDom> getList(String inQueryKey, TDto inSpec);
//	<S> T get  (Class inClass, S inSpec) throws InstantiationException, IllegalAccessException;
}