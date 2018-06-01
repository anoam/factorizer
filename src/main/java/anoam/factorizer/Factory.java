package anoam.factorizer;

public class Factory<T> {

    public Customizer<T> customize() {
        return new Customizer<>();
    }

    public T build() {
        return null;
    }
}
