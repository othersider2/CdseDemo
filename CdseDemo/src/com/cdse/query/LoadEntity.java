package com.cdse.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
import com.cdse.dto.CdseDto;

@Repository
public class LoadEntity<TDto extends CdseDto, TDom extends CdseEntity> implements CdseQuery<TDto, TDom> {


	@SuppressWarnings("unchecked")
	@Override
	public List<TDom> execute(SessionFactory inSessionFactory, TDto inDto) {
		List<TDom> outList = new ArrayList<TDom>();
		outList.add((TDom) inSessionFactory.getCurrentSession().get(inDto.getClassType(), inDto.getId()));
		
		
		return outList;
	}

}
