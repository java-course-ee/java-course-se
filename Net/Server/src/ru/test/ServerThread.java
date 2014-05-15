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

public class ServerThread extends Thread{
    
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("New server connection from " + socket.getInetAddress() + ":" + socket.getPort());
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            
            StringBuilder sb = new StringBuilder("Hello, ");
            
            String userName = br.readLine();
            System.out.println("Recieved from client: " + userName);
            
            sb.append(userName);
            
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
            
            System.out.println("Sent to client: " + sb.toString());

            br.close();
            bw.close();
            
            socket.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
    }
}
