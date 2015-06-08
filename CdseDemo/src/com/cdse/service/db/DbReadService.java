package com.cdse.service.db;

import java.io.IOException;
import java.util.List;

import com.cdse.dao.ReadDao;
import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;
import com.cdse.service.ReadService;

public interface DbReadService<TDom extends CdseEntity, TInDto extends CdseDto, TOutDto> extends ReadService<TInDto, TOutDto> {
}
