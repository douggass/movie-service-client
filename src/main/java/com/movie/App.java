package com.movie;

import static com.movie.properties.PropertiesLoader.getValues;

import java.util.Optional;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.movie.client.ClientSocket;
import com.movie.module.ClientModule;
import com.movie.module.GeneralModule;
import com.movie.module.HandleModule;

public class App {

	public static void main(String[] args) {

		final String ip = Optional.ofNullable(getValues("client.ip"))
				.orElseThrow(() -> new RuntimeException("IP do servidor não informada"));

		final int port = Optional.ofNullable(getValues("client.port"))
				.map(Integer::valueOf)
				.orElseThrow(() -> new RuntimeException("Porta do servidor não informada"));

		final Injector injector = Guice.createInjector(new ClientModule(), new GeneralModule(), new HandleModule());

		injector.getInstance(ClientSocket.class).start(ip, port);
	}
}
