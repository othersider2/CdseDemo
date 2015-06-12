package com.cdse.dao;

import java.io.IOException;

public interface WriteDao<TDom> {
	void execute(TDom inDom) throws IOException;
}
