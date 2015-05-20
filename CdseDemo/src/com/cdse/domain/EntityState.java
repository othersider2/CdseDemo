package com.cdse.domain;

public enum EntityState {
	
	NEW("N"), 
	OLD("O"), 
	DIRTY("D");
	 
	private String statusCode;
 
	private EntityState(String s) {
		statusCode = s;
	}
 
	public String getStatusCode() {
		return statusCode;
	}
 
}
