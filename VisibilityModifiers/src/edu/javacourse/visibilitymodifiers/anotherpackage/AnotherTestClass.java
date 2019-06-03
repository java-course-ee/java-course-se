package edu.javacourse.visibilitymodifiers.anotherpackage;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class AnotherTestClass {

    public void publicModifierMethod() {
        privateModifierMethod();
    }

    void defaultModifierMethod() {
        privateModifierMethod();
    }

    private void privateModifierMethod() {

    }

}
