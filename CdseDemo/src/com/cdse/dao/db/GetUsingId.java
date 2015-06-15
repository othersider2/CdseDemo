package com.cdse.dao.db;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.dao.ReadRecordDao;
import com.cdse.domain.CdseEntity;
import com.cdse.dto.Identifiable;

@Repository
public abstract class GetUsingId<TDom extends CdseEntity, TDto extends Identifiable> implements ReadRecordDao<TDom, TDto> {

	protected abstract TDom getDomObject();

	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public TDom execute(TDto inDto) {
		return (TDom) sessionFactory.getCurrentSession().get(getDomObject().getClass(), Integer.parseInt(inDto.getId()));
	}
}
