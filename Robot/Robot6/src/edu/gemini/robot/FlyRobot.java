package edu.gemini.robot;

import edu.gemini.robot.exception.CircleException;
import edu.gemini.robot.exception.RobotException;

public class FlyRobot implements Robot, Circle {

    public void forward(int distance) throws RobotException {
        System.out.println("FlyRobot forward distance:" + distance);
    }

    public void turnLeft(int angle) throws RobotException {
        System.out.println("FlyRobot turn to the left angle:" + angle);
    }

    public void turnRight(int angle) throws RobotException {
        System.out.println("FlyRobot turn to the right angle:" + angle);
    }

    public void drawCircle(int radius) throws CircleException {
        throw new CircleException("Can't create circle");
        //System.out.println("FlyRobot draws circle:" + radius);
    }

}
