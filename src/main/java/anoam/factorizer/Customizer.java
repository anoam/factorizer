package anoam.factorizer;

class Customizer<T> {

    public Customizer<T> stringAttribute(String attrName, String value) {
        return this;
    }

    public T build() {
        return null;
    }
}
