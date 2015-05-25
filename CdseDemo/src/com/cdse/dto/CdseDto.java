package com.cdse.dto;

import com.cdse.domain.CdseEntity;

public interface CdseDto {
	int getId();
	<TDom extends CdseEntity> void copyTo(TDom inDom);
	<TDom extends CdseEntity> void copyFrom(TDom inDom);
}
