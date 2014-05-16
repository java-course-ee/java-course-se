package edu.gemini.shape;

public class Main {

    public static void main(String[] args) {

        Square s = new Square("Square1", 10, 10);
        Circle c = new Circle("Circle1", 0, 0);

        System.out.println(s);
        s.move(10, 130);
        System.out.println(s);

        System.out.println(c);
        c.move(10, 30);
        System.out.println(c);
    }

}
