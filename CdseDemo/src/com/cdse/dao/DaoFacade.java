package com.cdse.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.cdse.dto.Identifiable;

public class DaoFacade<TResource, TInDto extends Identifiable> implements CdseDao<TResource, TInDto> {

	private Map<String, WriteDao<TResource>> writeDaoMap;

	private Map<String, ReadDao<TResource, TInDto>> readDaoMap;

	/* (non-Javadoc)
	 * @see com.cdse.dao.CdseDao#write(java.lang.String, TResource)
	 */
	@Override
	public void write(String inRequestMapping, TResource inResource) throws IOException {
		WriteDao<TResource> writeDao = getWriteDaoMap().get(inRequestMapping);
		writeDao.execute(inResource);
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.dao.CdseDao#get(java.lang.String, TResource, TInDto)
	 */
	@Override
	public TResource get(String inRequestMapping, TResource inPrototype, TInDto inInDto) throws IOException {
		
		TResource outResource = null;
		
		List<TResource> list = getList(inRequestMapping, inPrototype, inInDto);
		try {
			outResource = list.get(0);
		} catch (IndexOutOfBoundsException e) {
		}
		
		return outResource;
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.dao.CdseDao#getList(java.lang.String, TResource, TInDto)
	 */
	@Override
	public List<TResource> getList(String inRequestMapping, TResource inPrototype, TInDto inInDto) throws IOException {
		
		ReadDao<TResource, TInDto> readDao = getReadDaoMap().get(inRequestMapping);
		List<TResource> subjectList = readDao.execute(inPrototype, inInDto);
		return subjectList;
	}

	public Map<String, ReadDao<TResource, TInDto>> getReadDaoMap() {
		return readDaoMap;
	}

	public void setReadDaoMap(Map<String, ReadDao<TResource, TInDto>> readDaoMap) {
		this.readDaoMap = readDaoMap;
	}

	public Map<String, WriteDao<TResource>> getWriteDaoMap() {
		return writeDaoMap;
	}

	public void setWriteDaoMap(Map<String, WriteDao<TResource>> writeDaoMap) {
		this.writeDaoMap = writeDaoMap;
	}
	
}
