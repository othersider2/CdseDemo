package com.cdse.dao.db;

import java.io.IOException;

import com.cdse.domain.CdseEntity;

public interface WriteDao<TDom extends CdseEntity> {
	void execute(TDom inDom) throws IOException;
}
