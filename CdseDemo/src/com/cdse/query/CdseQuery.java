package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;

public interface CdseQuery<TDom extends CdseEntity, TDto extends CdseDto> {
	List<TDom> execute(SessionFactory inSessionFactory, TDom inPrototype, TDto inSpec);
	
}
