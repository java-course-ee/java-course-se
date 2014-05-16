package edu.gemini.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс - сервер, принимает запросы от клиентов и отдает данные
 */
public class BufferedSocketServer {

    public static void main(String args[]) throws Exception {
        // Определяем номер порта, который будет "слушать" сервер
        int cTosPortNumber = 1777;
        String str;

        // Пишем, что стартовали сервер
        System.out.println("Client is started");

        // Открыть серверный сокет (ServerSocket)
        // Это специальный класс для сетевого взаимодействия с серверной стороны
        ServerSocket servSocket = new ServerSocket(cTosPortNumber);
        System.out.println("Waiting for a connection on " + cTosPortNumber);

        // Получаем данные от клиента - они приходят к нам в виде обхекта класса Socket
        // accept - метод, который ожидает прихода запросов на порт
        Socket fromClientSocket = servSocket.accept();

        // Создать поток для записи симовлов в сокет
        PrintWriter pw = new PrintWriter(fromClientSocket.getOutputStream(), true);

        // Создать поток для чтения символов из сокета
        // Для этого надо открыть поток сокета - socket1.getInputStream()
        // Потом перобразовать его в поток символов - new InputStreamReader
        // И уже потом сделать его читателем строк - BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));

        // Читаем сообщения от клиента до тех пор пока он не скажет "bye" или окончит связь
        while ((str = br.readLine()) != null) {
            // Печатаем сообщение
            System.out.println("The message: " + str);

            // Сравниваем с "bye" и если что - выходим из цикла
            if (str.equals("bye")) {
                // Тоже говорим клиенту "bye"
                pw.println("bye");
                // Выходим из цикла
                break;
            } else {
                str = "Server returns " + str;
                pw.println(str);
            }
        }
        pw.close();
        br.close();

        fromClientSocket.close();
    }
}
