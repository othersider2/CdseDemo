package com.cdse.service.read;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CompositeReadListService<TInDto, TOutDto> implements ReadListService<TInDto, TOutDto> {
	
	private List<ReadListService<TInDto, TOutDto>> readServiceList;
	
	@Override
	public void execute(String inRequestMapping, TInDto inDto, Map<String, TOutDto> inOutDtoList) throws IOException {
		
		for (ReadListService<TInDto, TOutDto> subService : getReadServiceList()) {
			subService.execute(inRequestMapping, inDto, inOutDtoList);
		}
	}

	public List<ReadListService<TInDto, TOutDto>> getReadServiceList() {
		return readServiceList;
	}

	public void setReadServiceList(List<ReadListService<TInDto, TOutDto>> readServiceList) {
		this.readServiceList = readServiceList;
	}

}
