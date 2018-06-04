package anoam.factorizer;

import java.lang.reflect.Field;

class SequencedAssignedAttribute extends AssignedAttribute {

    private SequenceConverter converter;
    private Counter counter;

    SequencedAssignedAttribute(Field field, SequenceConverter converter, Counter counter) {
        super(field);
        this.converter = converter;
        this.counter = counter;
    }

    static SequencedAssignedAttribute build(Class klass, String fieldName, SequenceConverter converter) {
        try {
            Field field = klass.getDeclaredField(fieldName);

            return new SequencedAssignedAttribute(field, converter, new ConcurrentCounter());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void assign(Object object) {
        Field field = getField();
        assert (field.getDeclaringClass().equals(object.getClass()));

        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);

        try {
            field.set(object, getValue());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            // TODO: check if it necessary
            field.setAccessible(isAccessible);
        }
    }

    private Object getValue() {
        return converter.apply(counter.next());
    }
}
