package edu.gemini.robot;

import edu.gemini.robot.exception.RobotException;

public interface Robot {

    public void forward(int distance) throws RobotException;
    public void turnLeft(int angle) throws RobotException;
    public void turnRight(int angle) throws RobotException;
}
