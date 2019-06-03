package edu.javacourse.visibilitymodifiers;

import edu.javacourse.visibilitymodifiers.anotherpackage.AnotherTestClass;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class Main {

    public static void main(String[] args) {

        TestClass testClass = new TestClass();

        testClass.publicModifierMethod();
        testClass.defaultModifierMethod();
//        testClass.privateModifierMethod();

        AnotherTestClass anotherTestClass = new AnotherTestClass();
        anotherTestClass.publicModifierMethod();
//        anotherTestClass.defaultModifierMethod();
//        anotherTestClass.privateModifierMethod();

    }

}
