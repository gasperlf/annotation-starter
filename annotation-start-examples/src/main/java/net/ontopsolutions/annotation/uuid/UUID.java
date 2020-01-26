package net.ontopsolutions.annotation.uuid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(validatedBy = {UUIDValidator.class})
@Documented
public @interface UUID {

    String message() default "UUID is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
