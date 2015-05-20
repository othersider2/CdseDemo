package com.cdse.service;

import java.io.IOException;
import java.util.List;

import com.cdse.domain.CdseEntity;

public interface CdseService<T extends CdseEntity> {
	void insert(T inEntity) throws IOException;
	void insertOrUpdate(T inEntity) throws IOException;
	void update(T inEntity) throws IOException;
	void delete(T inEntity) throws IOException;
	T get(String inQueryKey, T inSpec);
	List<T> getList(String inQueryKey, T inSpec);

}
