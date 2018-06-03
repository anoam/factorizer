package anoam.factorizer;

public class Factorizer<T> {

    private Class<T> klass;

    public Factorizer(Class<T> k) {
        klass = k;
    }


    public Factorizer<T> attribute(String attrName, Object value) {
        return this;
    }

    public Factory<T> build() {
        return null;
    }
}
