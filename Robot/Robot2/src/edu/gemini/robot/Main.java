package edu.gemini.robot;

public class Main {

    public static void main(String[] args) {

        System.out.println("Robot 1");
        Robot r1 = new Robot();
        for(int i=0; i<4; i++) {
            r1.forward(10);
            r1.turnLeft(90);
        }

        System.out.println();
        System.out.println("Robot 2");
        Robot2 r2 = new Robot2();
        for(int i=0; i<4; i++) {
            r2.forward(10);
            r2.turnLeft(90);
        }

    }

}
