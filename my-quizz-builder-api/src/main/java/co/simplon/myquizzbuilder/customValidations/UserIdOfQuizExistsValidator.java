package co.simplon.myquizzbuilder.customValidations;

import co.simplon.myquizzbuilder.services.QuizService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserIdOfQuizExistsValidator implements
	ConstraintValidator<UserIdOfQuizExists, Long> {

    private final QuizService service;

    public UserIdOfQuizExistsValidator(
	    QuizService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(Long userId,
	    ConstraintValidatorContext context) {
	if (userId != null) {
	    return this.service.userIdValueExists(userId);
	}
	return true;
    }
}
