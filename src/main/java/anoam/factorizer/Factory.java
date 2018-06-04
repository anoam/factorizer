package anoam.factorizer;

import java.util.List;

public class Factory<T> {

    private Class<T> klass;
    private List<AssignedAttribute> attributes;

    Factory(Class<T> k, List<AssignedAttribute> attrs) {
        klass = k;
        attributes = attrs;
    }

    public Customizer<T> customize() {
        return new Customizer<>();
    }

    public T build() {
        try {
            T result = klass.newInstance();

            for (AssignedAttribute attr : attributes) {
                attr.assign(result);
            }

            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
