package edu.gemini.reflection;

public class Main {

    public static void main(String[] args) {
        try {
            Class classDefinition = Class.forName("edu.gemini.reflection.StringGeneratorImpl");
            StringGenerator sg = (StringGenerator) classDefinition.newInstance();
            System.out.println("Generate:" + sg.generate());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
