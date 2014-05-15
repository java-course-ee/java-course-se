package ru.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author artem.ptonchakov@calisto.email
 * 
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 48225);
        System.out.println("Connected to server");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        System.out.print("Enter username: ");
        String userName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        
        bw.write(userName);
        bw.newLine();
        bw.flush();
        System.out.println("Sent to server: " + userName);

        System.out.println("Server response: " + br.readLine());
        
        br.close();
        bw.close();
        socket.close();
    }
}
