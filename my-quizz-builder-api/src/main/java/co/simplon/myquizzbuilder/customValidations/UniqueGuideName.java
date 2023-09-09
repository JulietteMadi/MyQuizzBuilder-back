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
@Constraint(validatedBy = UniqueGuideNameValidator.class)
public @interface UniqueGuideName {
    String message() default "Une fiche pratique porte déjà ce nom";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}