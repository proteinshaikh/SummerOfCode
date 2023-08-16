package Summer2023.a.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidateHeader {
    String clientId() default "x-client-id";

    String clientSecret() default "x-client-secret";

    Brand brand() default Brand.DEFAULT;

    String correlationId() default "correlation-id";

    enum Brand {
        DEFAULT, ONE, TWO, THREE
    }
}
