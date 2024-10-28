package winter2024.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// The annotation can be applied to fields
@Target(ElementType.FIELD)
// The annotation is available at runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateLength {
    int min() default 1;
    int max() default 255;
}

