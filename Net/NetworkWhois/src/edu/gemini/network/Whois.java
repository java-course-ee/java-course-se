package edu.gemini.network;

/**
 * Класс создает сокет и использует его для получения информации
 * от удаленного компьютера. Этот ответ можно скопировать
 * и увидеть, что это обычная HTML страничка
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {

    public static void main(String args[]) throws Exception {
        // Переменная для хранения количества считанных байтов
        int c;

        // Открываем сокет для доступа к компьютеру
        // по адресу "internic.net" (порт 43)
        Socket s = new Socket("internic.net", 80);

        // Открываем поток для записи в сокет (информация будет
        // посылаться от нас на удаленный компьютер
        InputStream in = s.getInputStream();
        // Открываем поток для чтения из сокета (информация будет
        // посылаться нам с удаленного компьютера
        OutputStream out = s.getOutputStream();

        // Готовим строчку с какими-то данными
        String str = "GET / HTTP/1.0\n\n";
        // Превращаем их в массив байт для передачи
        // Мы же используем поток, а он рабтает с байтами
        byte buf[] = str.getBytes();
        // Пишем
        out.write(buf);
        // И читаем результат
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
        s.close();
    }
}
