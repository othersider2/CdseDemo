package com.cdse.dto;

public interface CdseDto {
	int getId();
	<TDom> void copyTo(TDom inDom);
	<TDom> TDom copyTo();
	<TDom> void copyFrom(TDom inDom);
	<TDom> Class<TDom> getClassType();
}
