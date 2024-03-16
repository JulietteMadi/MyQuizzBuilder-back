package co.simplon.myquizzbuilder.customValidations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = UniqueQuizNameValidator.class)
public @interface UniqueQuizName {
    String message() default "Un autre quiz porte déjà ce nom";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}