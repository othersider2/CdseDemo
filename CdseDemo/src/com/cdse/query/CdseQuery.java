package com.cdse.query;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;

public interface CdseQuery<TSrc, TDom extends CdseEntity, TDto extends CdseDto> {
	List<TDom> execute(TSrc inSource, TDom inPrototype, TDto inSpec);	
}
