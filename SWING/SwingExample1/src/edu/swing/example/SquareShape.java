package edu.swing.example;

import java.awt.Graphics;
import javax.swing.JComponent;

public class SquareShape extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10, 10, getWidth() - 20, getHeight() - 20);
    }
}
