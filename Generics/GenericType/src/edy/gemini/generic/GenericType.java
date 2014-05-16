package edy.gemini.generic;

public class GenericType {

    public static <T> T getInstance(Class<T> theClass) throws IllegalAccessException, InstantiationException {
        return theClass.newInstance();
    }

    public static void main(String[] arg) {
        try {
            String string = getInstance(String.class);
            Integer integer = getInstance(Integer.class);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    }
}
