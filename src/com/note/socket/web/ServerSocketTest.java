package com.note.socket.web;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketTest {
	
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(6666);
		System.out.println(ss.isClosed());
		ss.accept();
		System.out.println(ss.getLocalPort());
		ss.close();
	}

}
