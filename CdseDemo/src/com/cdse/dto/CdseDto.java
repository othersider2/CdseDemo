package com.cdse.dto;

public interface CdseDto {
	int getId();
	<TDom> void copyTo(TDom inDom);
	<TDom> void copyFrom(TDom inDom);
}
