package anoam.factorizer;

import java.util.LinkedList;
import java.util.List;

public class Factorizer<T> {

    private Class<T> klass;
    private List<AssignedAttribute> attributes = new LinkedList<>();

    public Factorizer(Class<T> k) {
        klass = k;
    }


    public Factorizer<T> attribute(String attrName, Object value) {
        attributes.add(SimpleAssignedAttribute.build(klass, attrName, value));

        return this;
    }

    public Factorizer<T> attribute(String attrName, SequenceConverter converter) {
        attributes.add(SequencedAssignedAttribute.build(klass, attrName, converter));
        return this;
    }


    public Factory<T> build() {
        return new Factory<>(klass, attributes);
    }
}
