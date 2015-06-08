package com.cdse.dao.db;

import java.io.IOException;
import java.util.List;

import com.cdse.dao.ReadDao;
import com.cdse.domain.CdseEntity;
import com.cdse.dto.CdseDto;

public interface DbReadDao<TDom extends CdseEntity, TDto extends CdseDto> extends ReadDao<TDom, TDto> {
}
