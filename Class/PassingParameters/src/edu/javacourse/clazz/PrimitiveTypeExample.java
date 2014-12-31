package edu.javacourse.clazz;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class PrimitiveTypeExample {

    public static void main(String[] args) {

        int number = 5;
        System.out.println("Inside main: " + number);

        int returnedNumber = square(number);

        System.out.println("Inside main, number: " + number);
        System.out.println("Inside main, returnedNumber: " + returnedNumber);

    }

    public static int square(int i) {
        System.out.println("Inside square: " + i);
        i = i*i;
        System.out.println("Inside square after square: " + i);
        return i;
    }

}
