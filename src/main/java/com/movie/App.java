package com.movie;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.movie.module.ClientModule;
import com.movie.module.GeneralModule;
import com.movie.server.AppMovieServer;

public class App {

	public static void main(String[] args) {

		final Injector injector = Guice.createInjector(new ClientModule(), new GeneralModule());

		injector.getInstance(AppMovieServer.class).start();
	}
}
