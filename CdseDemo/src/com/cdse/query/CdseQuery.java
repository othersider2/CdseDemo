package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;

public interface CdseQuery<T extends CdseDto, TDom extends CdseEntity> {
	List<TDom> execute(SessionFactory inSessionFactory, T inSpec);
	
}
