package edu.gemini.print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ASaburov
 */
public class PrintMessage implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println(btn.getText());
    }

}
