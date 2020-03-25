package edu.javacourse.abstractclasses;

public abstract class Greeting {

    public String hello(String name) {
        return getPrefix() + " " + name;
    }

    protected abstract String getPrefix();

}
