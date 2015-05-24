package com.cdse.service;

import java.io.IOException;
import java.util.List;

import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;

public interface CdseService<TDto extends CdseDto> {
	void insert(TDto inDto) throws IOException;
	void insertOrUpdate(TDto inDto) throws IOException;
	void update(String inQueryKey, TDto inDto) throws IOException;
	void delete(TDto inDto) throws IOException;
	void get(String inQueryKey, TDto inDto);
	List<TDto> getList(String inQueryKey, TDto inDto);
}
