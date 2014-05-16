package edu.gemini.runnable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

// Для того, чтобы класс "стал" окном - наследуемся от класса JFrame (окно)
public class Clock extends JFrame implements ActionListener {

    public static final String START = "START";
    public static final String STOP = "STOP";
    private JLabel timeLabel;
    private MyThread timeThread;

    public Clock() {
        // Установить заголовок
        setTitle("ClockRunnable");

        // Создать текстовую метку
        timeLabel = new JLabel();

        // Выравнять метку по горизонтали - есть такой метод у Label
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Установить размер шрифта для метки  - есть такой метод у Label
        // Для этого создаем шрифт и сразу его отдаем методу setFont
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        timeLabel.setFont(f);

        // Добавить метку на основную панель окна
        getContentPane().add(timeLabel, BorderLayout.CENTER);

        // Создаем кнопку Start
        JButton start = new JButton(START);
        start.setActionCommand(START);
        // Добавляем слушателя к кнопке - это сама форма
        start.addActionListener(this);

        // Создаем кнопку Stop
        JButton stop = new JButton(STOP);
        stop.setActionCommand(STOP);
        // Добавляем слушателя к кнопке - это сама форма
        stop.addActionListener(this);

        // Помещаем их на панель
        getContentPane().add(start, BorderLayout.NORTH);
        getContentPane().add(stop, BorderLayout.SOUTH);

        // Установить размеры окна
        setBounds(100, 100, 300, 400);
    }

    public void setTime() {
        // Создаем объект для форматирования даты
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        // Устанавливаем новое значение для метки - сразу форматируем дату в строку
        // и устанавливаем новый текст
        timeLabel.setText(df.format(Calendar.getInstance().getTime()));

        // Более корректный вызов в отдельном потоке, который отвечает за графику
/*
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        m_time.setText(df.format(Calendar.getInstance().getTime()));
        }
        });
         */
    }

    public void actionPerformed(ActionEvent e) {
        // Сравниваем источник события с кнопкой start. Если нажата она - стартуем поток
        if (e.getActionCommand().equals(START)) {
            // ОБРАТИТЬ ВНИМАНИЕ !!!
            // Создаем отдельный поток, который запустит наш класс с интерфейсом Runnable
            timeThread = new MyThread(this);
            new Thread(timeThread).start();
        }
        // Сравниваем источник события с кнопкой stop. Если нажата она - останавливаем поток
        if (e.getActionCommand().equals(STOP)) {
            // Здесь необходимо написать остановку потока
        }
    }
}

class MyThread implements Runnable {

    private Clock clock;

    public MyThread(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        // В данном случае мы входим в бесконечный цикл
        while (true) {
            clock.setTime();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
            }
        }
    }
}
