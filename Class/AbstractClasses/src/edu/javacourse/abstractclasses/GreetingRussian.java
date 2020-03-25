package edu.javacourse.abstractclasses;

public class GreetingRussian extends Greeting {

    @Override
    protected String getPrefix() {
        return "Привет";
    }
}
