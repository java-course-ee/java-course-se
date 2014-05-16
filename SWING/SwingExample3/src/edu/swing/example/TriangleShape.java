package edu.swing.example;

import java.awt.Graphics;
import javax.swing.JComponent;

public class TriangleShape extends JComponent implements Shape {

    private int currentGap = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(getWidth()/2, currentGap, currentGap, getHeight()-2*currentGap);
        g.drawLine(currentGap, getHeight()-2*currentGap, getWidth()-2*currentGap, getHeight()-2*currentGap);
        g.drawLine(getWidth()-2*currentGap, getHeight()-2*currentGap, getWidth()/2, currentGap);
    }

    public void increase(int value) {
        currentGap -= value;
    }

    public void decrease(int value) {
        currentGap += value;
    }

}
