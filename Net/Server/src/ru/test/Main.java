package ru.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author artem.ptonchakov@calisto.email
 * 
 */

public class Main {
    
    private static List<ServerThread> threadList = new ArrayList<ServerThread>();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(48225);
        
        System.out.println("Server started");

        while (true) {
            Socket socket = ss.accept();

            ServerThread serverThread = new ServerThread(socket);
            Main.threadList.add(serverThread);
            serverThread.start();
        }

    }
}
