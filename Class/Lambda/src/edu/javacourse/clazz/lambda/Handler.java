package edu.javacourse.clazz.lambda;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Handler {

    void handle(Person person, ToStringer toStringer) {

        System.out.println("Handled person: " + toStringer.convertToString(person));

    }

}
