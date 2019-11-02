package edu.javacourse.methods;

public class Main {

    public static void main(String[] args) {
        Math math = new Math();
        int addResult = math.add(10, 3);
        int subResult = math.sub(44, 2);

        System.out.println("10 + 3 = " + addResult);
        System.out.println("44 - 2 = " + subResult);


        Logger log = new Logger();
        log.out("Hello");
        log.out("World");

    }

}
