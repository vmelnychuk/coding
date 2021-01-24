package io.learn.coding.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TcpEchoServer {
    private static final int BUFFER_SIZE = 32;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Parameter(s): <Port>");
        }
        int serverPort = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(serverPort);
        int receivedMessageSize;
        byte[] receivedBuffer = new byte[BUFFER_SIZE];
        while (true) {
            Socket clientSocket = serverSocket.accept();
            SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
            System.out.println("Handling client at " + clientAddress);
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            while ((receivedMessageSize = in.read(receivedBuffer)) != -1) {
                out.write(receivedBuffer, 0, receivedMessageSize);
            }
            clientSocket.close();
        }
    }
}
