/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Main {

    public static void main(String[] args) {

        Programmer ivan = new Ivan();
        Programmer vasiliy = new Vasiliy();

        System.out.println(ivan.sayHello());
        ivan.writeProgram();

        System.out.println("===========================");

        System.out.println(vasiliy.sayHello());
        vasiliy.writeProgram();

    }

}
