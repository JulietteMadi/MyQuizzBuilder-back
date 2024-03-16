package co.simplon.myquizzbuilder.customValidations;

import co.simplon.myquizzbuilder.services.QuizService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueQuizNameValidator implements
	ConstraintValidator<UniqueQuizName, String> {

    private final QuizService service;

    public UniqueQuizNameValidator(QuizService service) {
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
