package ru.netology;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {

        int port = 8085;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

            System.out.println("New connection accepted");

            String name = in.readLine();

            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
            System.exit(-1);
        }
    }
}

