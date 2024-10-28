package winter2024.customannotation;

import java.lang.reflect.Field;

public class AnnotationValidator {

    public static void validate(Object object) throws IllegalAccessException {
        Class<?> objClass = object.getClass();
        for (Field field : objClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(ValidateLength.class)) {
                ValidateLength validateLength = field.getAnnotation(ValidateLength.class);
                field.setAccessible(true);
                String fieldValue = (String) field.get(object);
                if (fieldValue.length() < validateLength.min() || fieldValue.length() > validateLength.max()) {
                    throw new IllegalArgumentException(
                            String.format("Field %s must have length between %d and %d",
                                    field.getName(), validateLength.min(), validateLength.max()));
                }
            }
        }
    }
}

