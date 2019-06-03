package edu.javacourse.clazz;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Passing primitive value into method:");
        int i = 10;
        System.out.println("\tBefore method invoke i=" + i);
        passPrivitive(i);
        System.out.println("\tAfter method invoke i=" + i);

        System.out.println();
        System.out.println();

        System.out.println("Passing object value to method:");
        Point p = new Point(10, 20);
        System.out.println("\tPoint before method invoke: " + p);
        passObject(p);
        System.out.println("\tPoint after method invoke: " + p);

    }

    public static void passPrivitive(int primitiveVariable) {
        System.out.println("\t\tInside method before change primitiveVariable=" + primitiveVariable);
        primitiveVariable++;
        System.out.println("\t\tInside method after change primitiveVariable=" + primitiveVariable);
    }

    public static void passObject(Point point) {
        System.out.println("\t\tInside method before change point: " + point);
        point.setX(28);
        point.setY(44);
        System.out.println("\t\tInside method after change point: " + point);
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return new StringBuilder("Point(").append(hashCode()).append(") {").append("x=").append(x).append(", y=").append(y).append('}').toString();
        }
    }

}
