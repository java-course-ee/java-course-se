package edu.gemini.generic;

public class GenericFactory<E> {

    Class theClass = null;

    public GenericFactory(Class theClass) {
        this.theClass = theClass;
    }

    public E createInstance()  throws IllegalAccessException, InstantiationException {
        return (E) this.theClass.newInstance();
    }
}
