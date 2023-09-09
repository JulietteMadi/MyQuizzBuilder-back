package co.simplon.myquizzbuilder.customValidations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = UniqueUrlValidator.class)
public @interface UniqueUrl {
    String message() default "Une fiche pratique pointe déjà vers cette url";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
