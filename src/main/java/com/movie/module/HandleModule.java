package com.movie.module;

import com.google.inject.AbstractModule;
import com.movie.handle.Handle;
import com.movie.handle.MoviesHandle;

public class HandleModule  extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(Handle.class).toInstance(new MoviesHandle());
	}

}
