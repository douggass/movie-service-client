package com.movie.module;

import static com.movie.properties.PropertiesLoader.getValues;

import java.util.Optional;

import com.google.inject.AbstractModule;
import com.movie.client.MovieClientSocket;

public class ClientModule extends AbstractModule {

	@Override
	protected void configure() {
		
		final String ip = Optional.ofNullable(getValues("client.ip"))
				.orElseThrow(() -> new RuntimeException("IP do servidor não informada"));

		final int port = Optional.ofNullable(getValues("client.port"))
				.map(Integer::valueOf)
				.orElseThrow(() -> new RuntimeException("Porta do servidor não informada"));
		
		bind(MovieClientSocket.class).toInstance(new MovieClientSocket(ip, port));
	}

}