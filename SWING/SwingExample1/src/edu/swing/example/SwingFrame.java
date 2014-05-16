package edu.swing.example;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class SwingFrame extends JFrame {

    public SwingFrame() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2,3));
        for(int i=0; i<3; i++) {
            SquareShape shape = new SquareShape();
            contentPane.add(shape);
        }
        for(int i=0; i<3; i++) {
            TriangleShape shape = new TriangleShape();
            contentPane.add(shape);
        }
        setBounds(10, 50, 500, 450);
    }

    public static void main(String[] arg) {
        SwingFrame f = new SwingFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
