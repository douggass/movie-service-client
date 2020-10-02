package com.movie.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.movie.handle.Handle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class MovieClientSocket implements ClientSocket {

	private Socket clientSocket;
	
	@Inject
	private Handle handle;

	@Override
	public void start(final String ip, final int port) {
		try {
			clientSocket = new Socket(ip, port);
			clientSocket.setKeepAlive(true);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			handle.handleInputOutput(in, out);
		} catch (IOException e) {
			log.error("Erro ao criar socket", e);
		} finally {
			stop();
		}
	}

	public void stop() {
		try {
			clientSocket.close();
		} catch (IOException e) {
			log.error("Erro ao parar Socket", e);
		}
	}

}
