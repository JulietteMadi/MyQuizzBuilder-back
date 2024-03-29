package co.simplon.myquizzbuilder.customValidations;

import java.util.List;

import co.simplon.myquizzbuilder.services.QuizService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnswersListMatchQuizValidator implements
	ConstraintValidator<AnswersListMatchQuiz, List<Boolean>> {

    private final QuizService service;

    public AnswersListMatchQuizValidator(
	    QuizService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(List<Boolean> answers,
	    ConstraintValidatorContext context) {
	if (answers != null) {
	    return this.service
		    .answersListMatchQuiz(answers);
	}
	return true;
    }
}
