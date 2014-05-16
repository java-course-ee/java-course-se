package edu.gemini.comparator;

/**
 * Тестовый класс для сравнения с разными полями
 * @author ASaburov
 */
public class TestClass {

    public String name;
    public Integer age;

    public TestClass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name:=" + name + ", Age=" + age;
    }
}
