package com.cdse.domain;

import java.io.IOException;

public interface CdseEntity {
	void setState(EntityState inEntityState);
	void populate() throws IOException;
}
