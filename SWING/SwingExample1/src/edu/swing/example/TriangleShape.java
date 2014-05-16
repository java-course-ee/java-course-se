package edu.swing.example;

import java.awt.Graphics;
import javax.swing.JComponent;

public class TriangleShape extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(getWidth()/2, 10, 10, getHeight()-20);
        g.drawLine(10, getHeight()-20, getWidth()-20, getHeight()-20);
        g.drawLine(getWidth()-20, getHeight()-20, getWidth()/2, 10);
    }

}
