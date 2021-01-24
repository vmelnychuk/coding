package io.learn.coding.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TcpEchoClient {
    public static final int DEFAULT_ECHO_PORT = 7;

    public static void main(String[] args) throws IOException {
        if (args.length < 2 || args.length > 3) {
            throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");
        }

        String server = args[0];
        byte[] data = args[1].getBytes();
        int serverPort = (args.length == 3) ? Integer.parseInt(args[2]) : DEFAULT_ECHO_PORT;
        Socket socket = new Socket(server, serverPort);
        System.out.println("Connected to server, sending echo string...");
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        out.write(data);
        int totalBytesReceived = 0;
        int bytesReceived = 0;
        while (totalBytesReceived < data.length) {
            if ((bytesReceived = in.read(data, totalBytesReceived, data.length - totalBytesReceived)) == -1) {
                throw new SocketException("Connection closed prematurely...");
            }
            totalBytesReceived += bytesReceived;
        }
        System.out.println("Received: " + new String(data));
        socket.close();
    }
}
