package com.cdse.domain;

import java.io.IOException;

public interface CdseEntity {
	int getId();
	void setState(EntityState inEntityState);
	void populate() throws IOException;
	<T> void copy(T inEntity);
}
