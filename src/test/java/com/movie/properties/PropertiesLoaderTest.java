package com.movie.properties;

import static com.movie.properties.PropertiesLoader.getValues;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class PropertiesLoaderTest {

	@Test
	public void getPropertyTest() throws IOException {
		Integer resultPort = Integer.valueOf(getValues("client.port"));
		String resultIp = getValues("client.ip");
		assertNotNull(resultPort);
		assertTrue(resultPort > 0);
		assertNotNull(resultIp);
	}
	
	@Test
	public void getPropertyWhenReturnNonExistentPropertiesTest() throws IOException {
		String result = getValues("teste.nao.existente");
		assertNull(result);
	}
}
