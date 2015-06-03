package com.cdse.dao.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdse.dao.CdseDao;
import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;
import com.cdse.query.CdseQuery;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Repository
public class CdseRestDaoImpl<TDom extends CdseEntity, TDto extends CdseDto> implements CdseDao<TDom, TDto> {

	@Autowired
    private WebResource webResource;

	private Map<String, CdseQuery<WebResource, TDom, TDto>> queryMap;

	/* (non-Javadoc)
	 * @see com.cdse.demo.dao.EntityDao#insert(com.cdse.demo.domain.Persons)
	 */
    @Override
	public void insert(TDom inDom) throws IOException {

//		webResource.getCurrentSession().save(inDom);
    }

	@Override
	public void insertOrUpdate(TDom inDom) throws IOException {
//		webResource.getCurrentSession().save(inDom);
	}

	@Override
	public void update(TDom inDom) throws IOException {
//		webResource.getCurrentSession().update(inDom);
	}

	@Override
	public void delete(TDom inDom) throws IOException {
//		webResource.getCurrentSession().delete(inDom);
	}

	@Override
	public TDom get(String inQueryKey, TDom inPrototype, TDto inDto) {
		return getList(inQueryKey, inPrototype, inDto).get(0);
	}

	@Override
	public List<TDom> getList(String inQueryKey, TDom inPrototype, TDto inDto) {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource("http://localhost:7001/RestWS/rest/person");
 
		CdseQuery<WebResource, TDom, TDto> cdseQuery = getQueryMap().get(inQueryKey);
		return cdseQuery.execute(webResource, inPrototype, inDto);
	}

	public Map<String, CdseQuery<WebResource, TDom, TDto>> getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map<String, CdseQuery<WebResource, TDom, TDto>> queryMap) {
		this.queryMap = queryMap;
	}


//	@Override
//	public <S> T get(Class inClass, S inSpec) throws InstantiationException, IllegalAccessException{
//		@SuppressWarnings("unchecked")
//		CdseQuery<T,S> query = (CdseQuery<T, S>) inClass.newInstance();;
//		return query.execute(inSpec);
//	}

}
