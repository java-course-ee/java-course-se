package edu.javacourse.abstractclasses;

public class UI {

    private String username;

    public UI(String username) {
        this.username = username;
    }

    public void draw(Greeting greeting) {
        final String hello = greeting.hello(username);
        System.out.println("UI: " + hello);
    }


}
