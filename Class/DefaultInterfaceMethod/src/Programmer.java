/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public interface Programmer {

    default String sayHello() {
        return "Hello";
    }

    void writeProgram();

}
