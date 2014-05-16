package edu.gemini.robot;

public class WeelRobot implements Robot {

    public void forward(int distance) {
        System.out.println("WeelRobot forward distance:" + distance);
    }

    public void turnLeft(int angle) {
        System.out.println("WeelRobot turn to the left angle:" + angle);
    }

    public void turnRight(int angle) {
        System.out.println("WeelRobot turn to the right angle:" + angle);
    }

}
