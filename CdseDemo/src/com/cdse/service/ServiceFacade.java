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
	public void write(String inRequstMapping, TinDto inInDto) throws IOException {
		getWriteService().execute(inRequstMapping, inInDto);
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.service.CdseService#get(java.lang.String, TinDto)
	 */
	@Override
	public TOutDto get(String inRequstMapping, TinDto inInDto) {
		
		TOutDto outDto = getOutDto();

		try {
			getReadRecordService().execute(inRequstMapping, inInDto, outDto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return outDto;
	}
	
	/* (non-Javadoc)
	 * @see com.cdse.service.CdseService#getList(java.lang.String, TinDto)
	 */
	@Override
	public List<TOutDto> getList(String inRequstMapping, TinDto inInDto) {
		
		Map<String, TOutDto> outDtoMap = new HashMap<String, TOutDto>();
		try {
			getReadListService().execute(inRequstMapping, inInDto, outDtoMap);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
