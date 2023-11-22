package co.simplon.myquizzbuilder.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.myquizzbuilder.dtos.TopicUpdateDto;
import co.simplon.myquizzbuilder.services.TopicService;

public class UniqueUpdateTopicNameValidator implements
	ConstraintValidator<UniqueUpdateTopicName, TopicUpdateDto> {

    private final TopicService service;

    public UniqueUpdateTopicNameValidator(
	    TopicService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(TopicUpdateDto inputs,
	    ConstraintValidatorContext context) {
	String name = inputs.getName();
	Long id = inputs.getId();
	if (name != null) {
	    return !this.service.nameValueExistsUpdate(name,
		    id);
	}
	return true;
    }
}