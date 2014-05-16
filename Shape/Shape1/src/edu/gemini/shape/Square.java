package edu.gemini.shape;

public class Square extends Shape {

    public Square() {
        super();
    }

    public Square(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void show() {
        System.out.println("Show square " + name + " x:" + getX() + " y:" + getY());
    }

    @Override
    public void hide() {
        System.out.println("Hide square " + name + " x:" + getX() + " y:" + getY());
    }
}
