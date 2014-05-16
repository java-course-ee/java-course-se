package edu.gemini.robot;

public class Main {

    public static void main(String[] args) {

        Robot[] r = new Robot[2];

        // Если попробовать сразу обратиться к элементу массива, то ничего не получится.
        //r[0].forward(100);

        r[0] = new Robot();
        r[1] = new Robot2();
        for (int j = 0; j < r.length; j++) {
            System.out.println();
            System.out.println("Robot:" + r[j].getClass().getSimpleName());
            for (int i = 0; i < 4; i++) {
                r[j].forward(10);
                r[j].turnLeft(90);
            }
        }
    }
}
