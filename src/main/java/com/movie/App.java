package com.movie;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.movie.module.ClientModule;
import com.movie.module.GeneralModule;
import com.movie.server.AppMovieServer;

public class App {

	public static void main(String[] args) {
		
		final String query = Optional.ofNullable(args)
									.filter(item -> item.length > 0)
									.map(item -> StringUtils.join(item, " "))
									.orElseThrow(() -> new RuntimeException("Não foram encontrados argumentos"));
		
		final Injector injector = Guice.createInjector(
				new ClientModule(), 
				new GeneralModule());

		injector.getInstance(AppMovieServer.class).start(query);
	}
}
