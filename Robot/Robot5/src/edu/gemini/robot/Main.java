package edu.gemini.robot;

public class Main {

    public static void main(String[] args) {

        Robot[] r = new Robot[4];
        r[0] = new WeelRobot();
        r[1] = new FlyRobot();
        r[2] = new FlyRobot();
        r[3] = new WeelRobot();
        for (int j = 0; j < r.length; j++) {
            System.out.println();
            System.out.println("Robot:" + r[j].getClass().getSimpleName());
            for (int i = 0; i < 4; i++) {
                r[j].forward(10);
                r[j].turnLeft(90);
            }
        }

        Circle[] c = new Circle[2];
        c[0] = new FlyRobot();
        c[1] = new FlyRobot();
        for (int j = 0; j < c.length; j++) {
            System.out.println();
            System.out.println("Circle:" + c[j].getClass().getSimpleName());
            c[j].drawCircle(10);
        }

        for (int j = 0; j < r.length; j++) {
            if (r[j] instanceof Circle) {
                System.out.println();
                System.out.println("Circle:" + r[j].getClass().getSimpleName());
                Circle cOne = (Circle) r[j];
                cOne.drawCircle(20);
            }
        }
    }
}
