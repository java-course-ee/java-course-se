package edu.gemini.robot;

import edu.gemini.robot.exception.CircleException;

public interface Circle {
    public void drawCircle(int radius) throws CircleException;
}
