package co.simplon.myquizzbuilder.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.myquizzbuilder.services.UserService;

public class UniqueUserEmailValidator implements
	ConstraintValidator<UniqueUserEmail, String> {
    private final UserService service;

    public UniqueUserEmailValidator(UserService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String email,
	    ConstraintValidatorContext context) {
	if (email != null) {
	    return !this.service.emailValueExists(email);
	}
	return true;
    }
}
