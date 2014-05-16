package edu.gemini.generic;

public class Main {

    public static void main(String[] arg) {
        try {
            GenericFactory<String> factory1 = new GenericFactory<String>(String.class);
            String stringInstance = factory1.createInstance();

            GenericFactory<Integer> factory2 = new GenericFactory<Integer>(Integer.class);
            Integer integerInstance = factory2.createInstance();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    }
}
