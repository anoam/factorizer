package anoam.factorizer;

public class Factorizer<T> {

    private Class<T> klass;

    public Factorizer(Class<T> k) {
        klass = k;
    }


    public Factorizer<T> stringAttribute(String attrName, String value) {
        return this;
    }

    public Factory<T> build() {
        return null;
    }
}
