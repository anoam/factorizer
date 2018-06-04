package anoam.factorizer;

import java.lang.reflect.Field;

abstract class AssignedAttribute {

    private Field field;

    protected Field getField() {
        return field;
    }

    AssignedAttribute(Field f) {
        field = f;
    }

    abstract void assign(Object object);
}
