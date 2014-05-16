package edu.gemini.shape;

public class Circle extends Shape {

    public Circle() {
        super();
    }

    public Circle(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void show() {
        System.out.println("Show circle " + name + " x:" + getX() + " y:" + getY());
    }

    @Override
    public void hide() {
        System.out.println("Hide circle " + name + " x:" + getX() + " y:" + getY());
    }

}
