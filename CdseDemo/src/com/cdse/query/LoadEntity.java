package com.cdse.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
import com.cdse.dto.CdseDto;

@Repository
public class LoadEntity<TDom extends CdseEntity, TDto extends CdseDto> implements CdseQuery<TDom, TDto> {


	@SuppressWarnings("unchecked")
	@Override
	public List<TDom> execute(SessionFactory inSessionFactory, TDom inPrototype, TDto inDto) {
		List<TDom> outList = new ArrayList<TDom>();
		outList.add((TDom) inSessionFactory.getCurrentSession().get(inPrototype.getClass(), inDto.getId()));
			
		return outList;
	}

}
