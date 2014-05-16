package edu.swing.example;

import java.awt.Graphics;

public class TriangleShape extends Shape {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(getWidth()/2, 10, 10, getHeight()-20);
        g.drawLine(10, getHeight()-20, getWidth()-20, getHeight()-20);
        g.drawLine(getWidth()-20, getHeight()-20, getWidth()/2, 10);
    }

    @Override
    public void increase(int value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void decrease(int value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
