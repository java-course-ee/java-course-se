package edu.gemini.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Класс - клиент для получения данных из сокета
 */
public class BufferedSocketClient {

    public static void main(String args[]) throws Exception {
        // Определяем номер порта, на котором нас ожидает сервер для ответа
        int portNumber = 1777;
        // Подготавливаем строку для запроса
        String str = "Тестовая строка для передачи";

        // Пишем, что стартовали клиент
        System.out.println("Client is started");

        // Открыть сокет (Socket) для обращения к локальному компьютеру (InetAddress.getLocalHost())
        // Это специальный класс для сетевого взаимодействия c клиентской стороны
        Socket socket1 = new Socket(InetAddress.getLocalHost(), portNumber);

        // Создать поток для чтения символов из сокета
        // Для этого надо открыть поток сокета - socket1.getInputStream()
        // Потом перобразовать его в поток символов - new InputStreamReader
        // И уже потом сделать его читателем строк - BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));

        // Создать поток для записи симовлов в сокет
        PrintWriter pw = new PrintWriter(socket1.getOutputStream(), true);

        // Мечатаем строку в сокет
        pw.println(str);

        // Читаем, что нам ответили из сокета
        while ((str = br.readLine()) != null) {
            // Отправляем тестовую строку
            System.out.println(str);
            // И потом посылаем ему "bye" для окончания "разговора"
            pw.println("bye");

            if (str.equals("bye")) {
                break;
            }
        }

        br.close();
        pw.close();
        socket1.close();
    }
}
