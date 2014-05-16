package edu.swing.example;

import javax.swing.JComponent;

abstract public class Shape extends JComponent {

    protected int currentGap = 10;

    public void increase(int value) {
        currentGap -= value;
    }

    public void decrease(int value) {
        currentGap += value;
    }
}
