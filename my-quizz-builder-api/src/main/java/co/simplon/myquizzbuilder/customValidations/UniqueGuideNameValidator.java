package co.simplon.myquizzbuilder.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.myquizzbuilder.services.GuideService;

public class UniqueGuideNameValidator implements
	ConstraintValidator<UniqueGuideName, String> {
    private final GuideService service;

    public UniqueGuideNameValidator(GuideService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String name,
	    ConstraintValidatorContext context) {
	System.out.println(name);
	if (name != null) {
	    return !this.service.nameValueExists(name);
	}
	return true;
    }
}
