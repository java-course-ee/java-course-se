package edu.javacourse.clazz.lambda;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Main {

    public static void main(String[] args) {

        Person person = new Person(3L, "Franca Sabbatini");

        Handler handler = new Handler();

//        Class
        ClassToStringer classToStringer = new ClassToStringer();
        handler.handle(person, classToStringer);

        System.out.println("\r\n================================================\r\n");

//        Anonymous class
        handler.handle(person, new ToStringer() {
            @Override
            public String convertToString(Person person) {
                return "anonymous: " + person.getName();
            }
        });

        System.out.println("\r\n================================================\r\n");

//        Lambda long
        handler.handle(person, (Person p) -> { return "lambda_long: " + p.getName(); });

        System.out.println("\r\n================================================\r\n");

//        Lambda short
        handler.handle(person, (p) -> "lambda_short: " + p.getName());
    }

    private static class ClassToStringer implements ToStringer {

        @Override
        public String convertToString(Person person) {
            return "class: " + person.getName();
        }

    }

}
