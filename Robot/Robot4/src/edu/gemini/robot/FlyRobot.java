package edu.gemini.robot;

public class FlyRobot implements Robot {

    public void forward(int distance) {
        System.out.println("FlyRobot forward distance:" + distance);
    }

    public void turnLeft(int angle) {
        System.out.println("FlyRobot turn to the left angle:" + angle);
    }

    public void turnRight(int angle) {
        System.out.println("FlyRobot turn to the right angle:" + angle);
    }

}
