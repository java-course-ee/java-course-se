package edu.gemini.robot;

import edu.gemini.robot.exception.CircleException;
import edu.gemini.robot.exception.RobotException;

public class Main {

    public static void main(String[] args) {

        Robot[] r = new Robot[4];
        r[0] = new FlyRobot();
        r[1] = new WeelRobot();
        r[2] = new FlyRobot();
        r[3] = new WeelRobot();

        //start:
        for (int j = 0; j < r.length; j++) {
            System.out.println();
            System.out.println("Robot:" + r[j].getClass().getSimpleName());

            for (int i = 0; i < 4; i++) {
                try {
                    r[j].forward(10);
                    r[j].turnLeft(90);
                } catch (RobotException ex) {
                    System.out.println("Robot is not working:" + ex.getMessage());
                    // Автоматическая остановка текущего цикла
                    break;
                    // Автоматическая остановка текущего цикла с переходом
                    //break start;
                }
            }
        }

        Circle[] c = new Circle[2];
        c[0] = new FlyRobot();
        c[1] = new FlyRobot();
        for (int j = 0; j < c.length; j++) {
            System.out.println();
            System.out.println("Circle:" + c[j].getClass().getSimpleName());
            try {
                c[j].drawCircle(10);
            } catch (CircleException ex) {
                //ex.printStackTrace();
                System.out.println("Robot is not working:" + ex.getMessage());
            }
        }
    }
}
