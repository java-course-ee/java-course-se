package edu.javacourse.abstractclasses;

public class Main {

    public static void main(String[] args) {
        final Greeting greetingEnglish = new GreetingEnglish();
        final Greeting greetingRussian = new GreetingRussian();

// Cannot instantiate abstract class
//        Greeting g = new Greeting();
//        final String helloVasiliy = g.hello("Vasiliy");

        final UI ui = new UI("Jane");
        ui.draw(greetingEnglish);
        ui.draw(greetingRussian);
    }
}
