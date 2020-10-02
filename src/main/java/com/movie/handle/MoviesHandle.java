package com.movie.handle;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.movie.dto.Input;
import com.movie.dto.Output;
import com.movie.utils.Mapper;

import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class MoviesHandle implements Handle {

	private static final String SAIR = "sair";
	
	@Inject
	private Mapper mapper;
	
	@Override
	public void handleInputOutput(BufferedReader in, PrintWriter out) {
		boolean runnig = true;
		while (runnig) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Informe o filme para pesquisar ou sair para finalizar:");
			String query = scanner.next();
			if (SAIR.equals(query)) {
				scanner.close();
				runnig = false;
			}
			final Input input = Input.builder()
					.query(query)
					.length(query.length())
					.build();

			final String xml = mapper.toXml(input);
			System.out.println(findMovies(in, out, xml).getPayload());
			System.out.println("--------------------------------- \n");
		}
	}

	public Output findMovies(BufferedReader in, PrintWriter out, String xml) {
		try {
			out.print(xml);
			String str;
			StringBuilder responseString = new StringBuilder();
			while ((str = in.readLine()) != null) {
				responseString.append(str).append("\n");
				if (str.contains("</Output>")) {
					out.println(".");
				}
			}
			in.close();
			out.close();
			return mapper.fromXml(responseString.toString());
		} catch (Exception e) {
			log.error("Erro ao tratar request/response", e);
			return null;
		}
	}

}
