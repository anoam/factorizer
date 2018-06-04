package anoam.factorizer;

import sun.reflect.misc.FieldUtil;

import java.lang.reflect.Field;

class AssignedAttribute {

    private Field field;
    private Object value;

    static AssignedAttribute build(Class klass, String fieldName, Object value) {
        try {
            Field field = klass.getDeclaredField(fieldName);

            return new AssignedAttribute(field, value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private AssignedAttribute(Field f, Object v) {
        field = f;
        value = v;
    }

    void assign(Object object) {
        assert(field.getDeclaringClass().equals(object.getClass()));

        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);

        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            // TODO: check if it necessary
            field.setAccessible(isAccessible);
        }
    }
}
