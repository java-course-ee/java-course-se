package edu.gemini.annotation;

import java.lang.annotation.*;

/**
 * Пример использования аннотаций
 */

// Использование аннотации Debug - в ней мы можем использовать поле "comment"
@Debug(comment = "Comment for Main class")
public class Main {

    // Использование аннотации Debug - в ней мы можем использовать поле "comment"
    @Debug(comment = "Comment for member production")
    public boolean production = true;

    // Использование аннотации Debug - в ней мы можем использовать поле "comment"
    @Debug(comment = "Comment for testMethod")
    public void testMethod() {
    }

    public static void main(String[] args) {
        Main mt = new Main();
        try {
            // Получаем список аннотаций для класса Main
            Annotation[] ant1 = mt.getClass().getAnnotations();
            for (Annotation a : ant1) {
                System.out.println(a);
            }
            Debug d1 = (Debug)mt.getClass().getAnnotation(Debug.class);
            System.out.println("Comment:" + d1.comment());
            System.out.println("-----------------------");

            // Получаем список аннотаций для метода "testMethod"
            Annotation[] ant2 = mt.getClass().getMethod("testMethod").getAnnotations();
            for (Annotation a : ant2) {
                System.out.println(a);
            }
            Debug d2 = (Debug)mt.getClass().getMethod("testMethod").getAnnotation(Debug.class);
            System.out.println("Comment:" + d2.comment());
            System.out.println("-----------------------");

            // Получаем список аннотаций для поля "production"
            Annotation[] ant3 = mt.getClass().getField("production").getAnnotations();
            for (Annotation a : ant3) {
                System.out.println(a);
            }
            Debug d3 = (Debug)mt.getClass().getField("production").getAnnotation(Debug.class);
            System.out.println("Comment:" + d3.comment());

        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }
    }
}
