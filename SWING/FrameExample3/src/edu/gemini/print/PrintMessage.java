package edu.gemini.print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;

/**
 *
 * @author ASaburov
 */
public class PrintMessage implements ActionListener, MouseMotionListener {

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println(btn.getText());
    }

    public void mouseDragged(MouseEvent e) {
        System.out.println("Drag:" + e.getX() + ":" + e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        System.out.println("Move:" + e.getX() + ":" + e.getY());
    }

}
