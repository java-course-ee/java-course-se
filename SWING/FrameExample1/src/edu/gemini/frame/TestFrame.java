package edu.gemini.frame;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASaburov
 */
public class TestFrame extends JFrame {

    public TestFrame() {
        JButton b1 = new JButton("Жми меня наверху");
        getContentPane().add(b1, BorderLayout.NORTH);

        JButton b2 = new JButton("Жми меня внизу");
        getContentPane().add(b2, BorderLayout.SOUTH);

        setBounds(200, 200, 300, 250);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                TestFrame t = new TestFrame();
                t.setDefaultCloseOperation(TestFrame.EXIT_ON_CLOSE);
                t.setVisible(true);
            }
        });
    }
}
