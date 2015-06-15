package com.cdse.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdse.dto.Identifiable;
import com.cdse.service.read.ReadListService;
import com.cdse.service.read.ReadRecordService;
import com.cdse.service.write.WriteService;

public abstract class ServiceFacade<TinDto extends Identifiable, TOutDto> implements CdseService<TinDto, TOutDto> {

	private WriteService<TinDto> writeService;

	private ReadListService<TinDto, TOutDto> readListService;

	private ReadRecordService<TinDto, TOutDto> readRecordService;

	protected abstract TOutDto getOutDto();

	/* (non-Javadoc)
	 * @see com.cdse.service.CdseService#write(java.lang.String, TinDto)
	 */
	@Override
	public void insert(TinDto inInDto) throws IOException {
		getWriteService().execute("insert", inInDto);
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.service.CdseService#write(java.lang.String, TinDto)
	 */
	@Override
	public void update(TinDto inInDto) throws IOException {
		getWriteService().execute("update", inInDto);
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.service.CdseService#write(java.lang.String, TinDto)
	 */
	@Override
	public void delete(TinDto inInDto) throws IOException {
		getWriteService().execute("delete", inInDto);
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.service.CdseService#get(java.lang.String, TinDto)
	 */
	@Override
	public TOutDto get(String inRequstMapping, TinDto inInDto) throws IOException {		
		TOutDto outDto = getOutDto();
		getReadRecordService().execute(inRequstMapping, inInDto, outDto);		
		return outDto;
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.service.CdseService#getList(java.lang.String, TinDto)
	 */
	@Override
	public List<TOutDto> getList(String inRequstMapping, TinDto inInDto) throws IOException {
		
		Map<String, TOutDto> outDtoMap = new HashMap<String, TOutDto>();
		getReadListService().execute(inRequstMapping, inInDto, outDtoMap);
		return new ArrayList<TOutDto>(outDtoMap.values());
	}

	public WriteService<TinDto> getWriteService() {
		return writeService;
	}

	public void setWriteService(WriteService<TinDto> writeService) {
		this.writeService = writeService;
	}

	public ReadListService<TinDto, TOutDto> getReadListService() {
		return readListService;
	}

	public void setReadListService(ReadListService<TinDto, TOutDto> readService) {
		this.readListService = readService;
	}

	public ReadRecordService<TinDto, TOutDto> getReadRecordService() {
		return readRecordService;
	}

	public void setReadRecordService(ReadRecordService<TinDto, TOutDto> readRecordService) {
		this.readRecordService = readRecordService;
	}
	
}
