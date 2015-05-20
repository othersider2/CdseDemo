package com.cdse.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.domain.CdseEntity;
import com.cdse.query.CdseQuery;

@Repository
public class CdseDaoImpl<T  extends CdseEntity> implements CdseDao<T> {

	@Autowired
    private SessionFactory sessionFactory;

	private Map<String, CdseQuery<T>> queryMap;

	/* (non-Javadoc)
	 * @see com.cdse.demo.dao.EntityDao#insert(com.cdse.demo.domain.Contacts)
	 */
    @Override
	public void insert(T inEntity) throws IOException {

		sessionFactory.getCurrentSession().save(inEntity);
    }

	@Override
	public void insertOrUpdate(T inEntity) throws IOException {
		sessionFactory.getCurrentSession().saveOrUpdate(inEntity);
	}

	@Override
	public void update(T inEntity) throws IOException {
    	inEntity.populate();
		sessionFactory.getCurrentSession().update(inEntity);
	}

	@Override
	public void delete(T inEntity) throws IOException {
		sessionFactory.getCurrentSession().delete(inEntity);
	}

	@Override
	public T get(String inQueryKey, T inSpec) {
		return getList(inQueryKey, inSpec).get(0);
	}

	@Override
	public List<T> getList(String inQueryKey, T inSpec) {
		CdseQuery<T> cdseQuery = getQueryMap().get(inQueryKey);
		return cdseQuery.execute(sessionFactory, inSpec);
	}

	public Map<String, CdseQuery<T>> getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map<String, CdseQuery<T>> queryMap) {
		this.queryMap = queryMap;
	}


//	@Override
//	public <S> T get(Class inClass, S inSpec) throws InstantiationException, IllegalAccessException{
//		@SuppressWarnings("unchecked")
//		CdseQuery<T,S> query = (CdseQuery<T, S>) inClass.newInstance();;
//		return query.execute(inSpec);
//	}

}
