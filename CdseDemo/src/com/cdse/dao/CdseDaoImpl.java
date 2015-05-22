package com.cdse.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;
import com.cdse.query.CdseQuery;

@Repository
public class CdseDaoImpl<TDto extends CdseDto, TDom  extends CdseEntity> implements CdseDao<TDto, TDom> {

	@Autowired
    private SessionFactory sessionFactory;

	private Map<String, CdseQuery<TDto, TDom>> queryMap;

	/* (non-Javadoc)
	 * @see com.cdse.demo.dao.EntityDao#insert(com.cdse.demo.domain.Persons)
	 */
    @Override
	public void insert(TDom inEntity) throws IOException {

		sessionFactory.getCurrentSession().save(inEntity);
    }

	@Override
	public void insertOrUpdate(TDom inEntity) throws IOException {
		sessionFactory.getCurrentSession().save(inEntity);
	}

	@Override
	public void update(TDom inEntity) throws IOException {
		sessionFactory.getCurrentSession().update(inEntity);
	}

	@Override
	public void delete(TDom inEntity) throws IOException {
		sessionFactory.getCurrentSession().delete(inEntity);
	}

	@Override
	public TDom get(String inQueryKey, TDto inDto) {
		return getList(inQueryKey, inDto).get(0);
	}

	@Override
	public List<TDom> getList(String inQueryKey, TDto inDto) {
		CdseQuery<TDto, TDom> cdseQuery = getQueryMap().get(inQueryKey);
		return cdseQuery.execute(sessionFactory, inDto);
	}

	public Map<String, CdseQuery<TDto, TDom>> getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map<String, CdseQuery<TDto, TDom>> queryMap) {
		this.queryMap = queryMap;
	}


//	@Override
//	public <S> T get(Class inClass, S inSpec) throws InstantiationException, IllegalAccessException{
//		@SuppressWarnings("unchecked")
//		CdseQuery<T,S> query = (CdseQuery<T, S>) inClass.newInstance();;
//		return query.execute(inSpec);
//	}

}
