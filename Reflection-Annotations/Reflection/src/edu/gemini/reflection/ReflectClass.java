package edu.gemini.reflection;

/**
 * Класс для примера работы механизма reflection
 * @author ASaburov
 */
public class ReflectClass {

    private String value;

    public ReflectClass(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
