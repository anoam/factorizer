package anoam.factorizer;

import java.lang.reflect.Field;

class SimpleAssignedAttribute extends AssignedAttribute {

    private Object value;

    SimpleAssignedAttribute(Field f, Object v) {
        super(f);
        value = v;
    }

    static SimpleAssignedAttribute build(Class klass, String fieldName, Object value) {
        try {
            Field field = klass.getDeclaredField(fieldName);

            return new SimpleAssignedAttribute(field, value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void assign(Object object) {
        Field field = getField();
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
