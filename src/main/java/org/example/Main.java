package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    static final int PORT = 8099;
    static final String HOST ="localhost";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket( HOST, PORT);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {
            out.println("GET / HTTP/1.1 " + "\n" + "Host: " + HOST + " Port: " + PORT);
            String resp = in.readLine();
            System.out.println(resp);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}