package com.note.socket.web;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
			Socket s = new Socket("127.0.0.1", 6666);
	}
}
