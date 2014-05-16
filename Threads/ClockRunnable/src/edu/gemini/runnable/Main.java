package edu.gemini.runnable;

import javax.swing.JFrame;

/**
 *
 * @author ASaburov
 */
public class Main {

    public static void main(String[] args) {
        // Создать форму
        Clock cl = new Clock();
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.setVisible(true);
    }
}
