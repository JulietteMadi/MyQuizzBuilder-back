package co.simplon.myquizzbuilder.customValidations;

import co.simplon.myquizzbuilder.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserNameValidator implements
	ConstraintValidator<UniqueUserName, String> {

    private final UserService service;

    public UniqueUserNameValidator(UserService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String name,
	    ConstraintValidatorContext context) {
	if (name != null) {
	    return !this.service.nameValueExists(name);
	}
	return true;
    }
}
