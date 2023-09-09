package co.simplon.myquizzbuilder.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.myquizzbuilder.services.GuideService;

public class UniqueUrlValidator
	implements ConstraintValidator<UniqueUrl, String> {

    private final GuideService service;

    public UniqueUrlValidator(GuideService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String url,
	    ConstraintValidatorContext context) {
	System.out.println(url);
	if (url != null) {
	    return !this.service.urlValueExists(url);
	}
	return true;
    }

}
