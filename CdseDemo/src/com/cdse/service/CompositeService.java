package com.cdse.service;

import java.io.IOException;
import java.util.List;

public class CompositeService<TInDto, TOutDto> implements ReadService<TInDto, TOutDto> {
	
	private List<ReadService<TInDto, TOutDto>> readServiceList;
	
	@Override
	public void execute(String inRequestMapping, TInDto inDto, List<TOutDto> inOutDtoList) throws IOException {
		
		for (ReadService<TInDto, TOutDto> subService : getReadServiceList()) {
			subService.execute(inRequestMapping, inDto, inOutDtoList);
		}
	}

	public List<ReadService<TInDto, TOutDto>> getReadServiceList() {
		return readServiceList;
	}

	public void setReadServiceList(List<ReadService<TInDto, TOutDto>> readServiceList) {
		this.readServiceList = readServiceList;
	}

}
