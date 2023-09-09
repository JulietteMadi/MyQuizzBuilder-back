package co.simplon.myquizzbuilder.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.myquizzbuilder.services.TopicService;

public class UniqueTopicNameValidator implements
	ConstraintValidator<UniqueTopicName, String> {
    private final TopicService service;

    public UniqueTopicNameValidator(TopicService service) {
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
