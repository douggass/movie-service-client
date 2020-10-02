package com.movie.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.movie.dto.Input;
import com.movie.dto.Output;

import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class Mapper {

	@Inject
	private XmlMapper xmlMapper;

	public Output fromXml(final String xml) {
		try {
			return xmlMapper.readValue(xml, Output.class);
		} catch (JsonProcessingException e) {
			log.error("Erro ao realizar parse do xml", e);
			return null;
		}
	}

	public String toXml(final Input input) {
		try {
			return xmlMapper.writeValueAsString(input);
		} catch (JsonProcessingException e) {
			log.error("Erro criar xml", e);
			return null;
		}
	}

}
