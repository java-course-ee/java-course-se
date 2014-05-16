package edu.gemini.math;

import java.util.Random;

/**
 *
 * @author ASaburov
 */
public class Main {

    private static final int RAND_EXAMPLE = 5;

    public static void main(String[] args) {

        System.out.println("Математически функции");
        for (int i = 0; i < RAND_EXAMPLE; i++) {
            double d = Math.random()*10;
            System.out.println(d);
            System.out.println(Math.ceil(d));
            System.out.println(Math.floor(d));
        }

        System.out.println();
        System.out.println("Случайные числа");
        Random r = new Random();
        r.setSeed(0);
        for (int i = 0; i < RAND_EXAMPLE; i++) {
            System.out.println(r.nextGaussian());
        }
    }
}
