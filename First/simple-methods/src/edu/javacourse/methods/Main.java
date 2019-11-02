package edu.javacourse.methods;

public class Main {

    public static void main(String[] args) {
        Math math = new Math();
        int addResult = math.add(10, 3);
        int subResult = math.sub(44, 2);

        Logger log = new Logger();

        log.out("10 + 3 = " + addResult);
        log.out("44 - 2 = " + subResult);

        log.out("Hello");
        log.out("World");

    }

}
