package com.cdse.dao.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.dao.ReadDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
import com.cdse.dto.Identifiable;

@Repository
public class GetUsingId<TDom extends CdseEntity, TDto extends Identifiable> implements ReadDao<TDom, TDto> {

	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TDom> execute(TDom inPrototype, TDto inDto) {
		List<TDom> outList = new ArrayList<TDom>();
		outList.add((TDom) sessionFactory.getCurrentSession().get(inPrototype.getClass(), Integer.parseInt(inDto.getId())));
			
		return outList;
	}

}
