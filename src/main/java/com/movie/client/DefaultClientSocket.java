package com.movie.client;

import java.io.IOException;
import java.net.Socket;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public abstract class DefaultClientSocket {

	protected String ip;
	protected int port;

	protected Socket start() {
		try {
			Socket clientSocket = new Socket(ip, port);
			clientSocket.setKeepAlive(true);
			clientSocket.setSoTimeout(10000);
			return clientSocket;
		} catch (IOException e) {
			log.error("Erro ao criar socket", e);
			throw new RuntimeException("Erro ao iniciar socket", e);
		}
	}

}
