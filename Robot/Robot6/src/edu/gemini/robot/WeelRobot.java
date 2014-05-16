package edu.gemini.robot;

import edu.gemini.robot.exception.RobotException;

public class WeelRobot implements Robot {

    public void forward(int distance) throws RobotException {
        throw new RobotException("Robot can't go forward");
        //System.out.println("WeelRobot forward distance:" + distance);
    }

    public void turnLeft(int angle) throws RobotException {
        throw new RobotException("Robot can't turn to the left");
        //System.out.println("WeelRobot turn to the left angle:" + angle);
    }

    public void turnRight(int angle) throws RobotException {
        System.out.println("WeelRobot turn to the right angle:" + angle);
    }

}
