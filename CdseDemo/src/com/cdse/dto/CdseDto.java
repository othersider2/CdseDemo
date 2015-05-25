package com.cdse.dto;

import com.cdse.domain.CdseEntity;

public interface CdseDto<TDom extends CdseEntity> {
	int getId();
	void copyTo(TDom inDom);
	void copyFrom(TDom inDom);
}
