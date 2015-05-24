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
public class CdseDaoImpl<TDom  extends CdseEntity, TDto extends CdseDto> implements CdseDao<TDom, TDto> {

	@Autowired
    private SessionFactory sessionFactory;

	private Map<String, CdseQuery<TDom, TDto>> queryMap;

	/* (non-Javadoc)
	 * @see com.cdse.demo.dao.EntityDao#insert(com.cdse.demo.domain.Persons)
	 */
    @Override
	public void insert(TDom inDom) throws IOException {

		sessionFactory.getCurrentSession().save(inDom);
    }

	@Override
	public void insertOrUpdate(TDom inDom) throws IOException {
		sessionFactory.getCurrentSession().save(inDom);
	}

	@Override
	public void update(TDom inDom) throws IOException {
		sessionFactory.getCurrentSession().update(inDom);
	}

	@Override
	public void delete(TDom inDom) throws IOException {
		sessionFactory.getCurrentSession().delete(inDom);
	}

	@Override
	public TDom get(String inQueryKey, Class<TDom> inClass, TDto inDto) {
		return getList(inQueryKey, inClass, inDto).get(0);
	}

	@Override
	public List<TDom> getList(String inQueryKey, Class<TDom> inClass, TDto inDto) {
		CdseQuery<TDom, TDto> cdseQuery = getQueryMap().get(inQueryKey);
		return cdseQuery.execute(sessionFactory, inClass, inDto);
	}

	public Map<String, CdseQuery<TDom, TDto>> getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map<String, CdseQuery<TDom, TDto>> queryMap) {
		this.queryMap = queryMap;
	}


//	@Override
//	public <S> T get(Class inClass, S inSpec) throws InstantiationException, IllegalAccessException{
//		@SuppressWarnings("unchecked")
//		CdseQuery<T,S> query = (CdseQuery<T, S>) inClass.newInstance();;
//		return query.execute(inSpec);
//	}

}
