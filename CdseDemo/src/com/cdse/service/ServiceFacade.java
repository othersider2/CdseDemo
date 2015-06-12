package com.cdse.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdse.dto.Identifiable;
import com.cdse.service.read.ReadService;
import com.cdse.service.write.WriteService;

public class ServiceFacade<TinDto extends Identifiable, TOutDto> implements CdseService<TinDto, TOutDto> {

	private WriteService<TinDto> writeService;

	private ReadService<TinDto, TOutDto> readService;

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
		
		TOutDto outDto = null;

		List<TOutDto> list = getList(inRequstMapping, inInDto);
		try {
			outDto = list.get(0);
		} catch (IndexOutOfBoundsException e) {
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
			getReadService().execute(inRequstMapping, inInDto, outDtoMap);
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

	public ReadService<TinDto, TOutDto> getReadService() {
		return readService;
	}

	public void setReadService(ReadService<TinDto, TOutDto> readService) {
		this.readService = readService;
	}
	
}
