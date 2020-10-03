package com.movie.server;

import java.util.Objects;
import java.util.Scanner;

import com.google.inject.Inject;
import com.movie.client.MovieClientSocket;
import com.movie.dto.Input;
import com.movie.dto.Output;
import com.movie.utils.Mapper;

public class AppMovieServer {

	private static final String SAIR = "sair";

	@Inject
	private Mapper mapper;

	@Inject
	private MovieClientSocket movieClientSocket;

	public void start() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Informe o filme para pesquisar ou sair para finalizar:");
			String query = scanner.nextLine();
			if (Objects.nonNull(query) && SAIR.equalsIgnoreCase(query.trim())) {
				scanner.close();
				break;
			}
			final Input input = Input.builder().query(query).length(query.length()).build();
			final String xml = mapper.toXml(input);
			String xmlOutput = movieClientSocket.findMovies(xml);
			final Output output = mapper.fromXml(xmlOutput);
			scanner.reset();
			System.out.println(output.getPayload());
			System.out.println("--------------------------------- \n");
		}
	}

}
