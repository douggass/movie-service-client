package com.movie.module;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.inject.AbstractModule;

public class GeneralModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(XmlMapper.class);
	}

}
