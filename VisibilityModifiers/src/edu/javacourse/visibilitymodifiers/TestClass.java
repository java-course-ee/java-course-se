package edu.javacourse.visibilitymodifiers;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class TestClass {

    public void publicModifierMethod() {
        privateModifierMethod();
    }

    void defaultModifierMethod() {
        privateModifierMethod();
    }

    private void privateModifierMethod() {

    }



}
