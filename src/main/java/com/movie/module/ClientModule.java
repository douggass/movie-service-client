package com.movie.module;

import com.google.inject.AbstractModule;
import com.movie.client.ClientSocket;
import com.movie.client.MovieClientSocket;

public class ClientModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ClientSocket.class).toInstance(new MovieClientSocket());
	}

}