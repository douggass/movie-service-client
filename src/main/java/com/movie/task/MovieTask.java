package com.movie.task;

import java.util.Optional;

import com.google.inject.Inject;
import com.movie.client.MovieClientSocket;
import com.movie.dto.Input;
import com.movie.dto.Output;
import com.movie.utils.Mapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovieTask {

	@Inject
	private Mapper mapper;

	@Inject
	private MovieClientSocket movieClientSocket;

	public void findMovies(final String query) {
		log.info("Query: {}", query);

		final Input input = Input.builder().query(query).length(query.length()).build();
		final String xml = mapper.toXml(input);
		String xmlOutput = movieClientSocket.findMovies(xml);
		final Output output = mapper.fromXml(xmlOutput);

		log.info("Response: {}", output);

		final String response = Optional.ofNullable(output)
			.filter(item -> item.length > 0)
			.map(Output::getPayload)
			.orElse("Não foram encontrados filmes");

		System.out.println(response);
	}

}
