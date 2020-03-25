package edu.javacourse.abstractclasses;

public class GreetingEnglish extends Greeting {

    @Override
    protected String getPrefix() {
        return "Hello";
    }
}
