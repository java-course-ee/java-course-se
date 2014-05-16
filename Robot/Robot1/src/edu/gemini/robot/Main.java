package edu.gemini.robot;

public class Main {

    public static void main(String[] args) {
        Robot r1 = new Robot();

        r1.forward(2);
        r1.turnLeft(30);
        r1.forward(2);
        r1.turnLeft(90);
        r1.forward(2);
        r1.turnLeft(90);
        r1.forward(2);
    }

}
