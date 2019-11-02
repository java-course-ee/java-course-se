public class Main {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s);

        int length = s.length();
        System.out.println("Length: " + length);

        char c = s.charAt(1);
        System.out.println("Char[1]: " + c);

        s = s.replaceAll("World", "Lorem ipsum");
        System.out.println("Replaced String: " + s);

        s = s.toLowerCase();
        System.out.println("Lower: " + s);

        s = s.toUpperCase();
        System.out.println("Upper: " + s);


    }
}
