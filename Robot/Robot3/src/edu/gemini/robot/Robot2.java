package edu.gemini.robot;

public class Robot2 extends Robot {

    @Override
    public void turnLeft(int angle) {
        System.out.println("Turn Left angle:" + angle);
    }

    @Override
    public void turnRight(int angle) {
        System.out.println("Turn Right angle:" + angle);
    }

    @Override
    public void forward(int distance) {
        System.out.println("Forward distance:" + distance);
    }
}
