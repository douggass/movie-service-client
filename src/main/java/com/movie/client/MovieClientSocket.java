package com.movie.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.inject.Singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class MovieClientSocket extends DefaultClientSocket {

	public MovieClientSocket(String ip, int port) {
		super(ip, port);
	}

	public String findMovies(String message) {
		try (Socket clientSocket = start();
			 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		 	 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			return handleInOutFindMovies(in, out, message);			
		} catch (Exception e) {
			log.error("Erro realizar buscar filmes", e);
			throw new RuntimeException(e);
		}
	}

	public String handleInOutFindMovies(final BufferedReader in, final PrintWriter out, final String message)
			throws IOException {
		out.println(message);
		String str;
		StringBuilder responseString = new StringBuilder();
		while ((str = in.readLine()) != null) {
			responseString.append(str).append("\n");
			if (str.contains("</Output>")) {
				out.println(".");
			}
		}
		return responseString.toString();
	}

}
