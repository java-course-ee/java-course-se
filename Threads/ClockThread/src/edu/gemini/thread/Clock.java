package edu.gemini.thread;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

// Для того, чтобы класс "стал" окном - наследуемся от класса JFrame (окно)
public class Clock extends JFrame {

    private JLabel m_time;

    public Clock() {
        // Установить заголовок
        setTitle("ClockThread");

        // Создать текстовую метку
        m_time = new JLabel();

        // Выравнять метку по горизонтали - есть такой метод у Label
        m_time.setHorizontalAlignment(SwingConstants.CENTER);

        // Установить размер шрифта для метки  - есть такой метод у Label
        // Для эт ого создаем шрифт и сразу его отдаем методу setFont
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        m_time.setFont(f);

        // Добавить метку на основную панель окна
        getContentPane().add(m_time);

        // Установить размеры окна
        setBounds(0, 0, 300, 100);

        // ОБРАТИТЬ ВНИМАНИЕ !!!
        // Создаем отдельный поток, который должен обновлять значение метки
        Thread m_thr = new MyThread(this);
        m_thr.start();
    }

    public void setTime() {
        // Создаем объект для форматирования даты
//        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        // Устанавливаем новое значение для метки - сразу форматируем дату в строку
        // и устанавливаем новый текст
//        m_time.setText(df.format(Calendar.getInstance().getTime()));

        // Более корректный вызов в отдельном потоке, который отвечает за графику

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                m_time.setText(df.format(Calendar.getInstance().getTime()));
            }
        });

    }
}

class MyThread extends Thread {

    private Clock clock;

    public MyThread(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        while (true) {
            clock.setTime();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
