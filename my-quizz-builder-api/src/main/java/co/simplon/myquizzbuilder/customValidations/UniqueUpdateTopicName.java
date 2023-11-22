package co.simplon.myquizzbuilder.customValidations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Constraint(validatedBy = UniqueUpdateTopicNameValidator.class)
public @interface UniqueUpdateTopicName {
    String message() default "Un thème porte déjà ce nom";

    // Long id();

    // String name();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
