package pl.uracz.workAccident.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProtocolNumberValidator.class)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProtocolNumberValidation {
    String message() default "Protocol number already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
