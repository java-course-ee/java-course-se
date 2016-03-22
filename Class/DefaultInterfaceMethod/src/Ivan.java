/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Ivan implements Programmer {

    @Override
    public String sayHello() {
        return "Hello, I am Ivan. I can write programs.";
    }

    @Override
    public void writeProgram() {
        System.out.println("String s = null; s.toString();");
    }

}
