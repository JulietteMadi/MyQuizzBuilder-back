package co.simplon.myquizzbuilder.customValidations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Constraint(validatedBy = UniqueGuideValidator.class)
public @interface UniqueGuide {
    String message() default "Une fiche pratique pointe déjà vers cette url";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
