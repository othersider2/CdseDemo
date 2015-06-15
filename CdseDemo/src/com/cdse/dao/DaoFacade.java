package com.cdse.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.cdse.dto.Identifiable;

public class DaoFacade<TResource, TInDto extends Identifiable> implements CdseDao<TResource, TInDto> {

	private Map<String, WriteDao<TResource>> writeDaoMap;

	private Map<String, ReadRecordDao<TResource, TInDto>> readRecordDaoMap;

	private Map<String, ReadListDao<TResource, TInDto>> readListDaoMap;

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
	public TResource get(String inRequestMapping, TInDto inInDto) throws IOException {
		
		ReadRecordDao<TResource, TInDto> readDao = getReadRecordDaoMap().get(inRequestMapping);
		return readDao.execute(inInDto);
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.dao.CdseDao#getList(java.lang.String, TResource, TInDto)
	 */
	@Override
	public List<TResource> getList(String inRequestMapping, TInDto inInDto) throws IOException {
		
		ReadListDao<TResource, TInDto> readDao = getReadListDaoMap().get(inRequestMapping);
		return readDao.execute(inInDto);
	}

	public Map<String, ReadListDao<TResource, TInDto>> getReadListDaoMap() {
		return readListDaoMap;
	}

	public void setReadListDaoMap(Map<String, ReadListDao<TResource, TInDto>> readListDaoMap) {
		this.readListDaoMap = readListDaoMap;
	}

	public Map<String, WriteDao<TResource>> getWriteDaoMap() {
		return writeDaoMap;
	}

	public void setWriteDaoMap(Map<String, WriteDao<TResource>> writeDaoMap) {
		this.writeDaoMap = writeDaoMap;
	}

	public Map<String, ReadRecordDao<TResource, TInDto>> getReadRecordDaoMap() {
		return readRecordDaoMap;
	}

	public void setReadRecordDaoMap(Map<String, ReadRecordDao<TResource, TInDto>> readRecordDaoMap) {
		this.readRecordDaoMap = readRecordDaoMap;
	}
	
}
