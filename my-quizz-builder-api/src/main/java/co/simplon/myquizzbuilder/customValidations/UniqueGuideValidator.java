package co.simplon.myquizzbuilder.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.myquizzbuilder.dtos.GuideItemDto;
import co.simplon.myquizzbuilder.services.GuideService;

public class UniqueGuideValidator implements
	ConstraintValidator<UniqueGuide, GuideItemDto> {

    private final GuideService service;

    public UniqueGuideValidator(GuideService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(GuideItemDto inputs,
	    ConstraintValidatorContext context) {
	Long id = inputs.getId();
	String name = inputs.getName();
	String url = inputs.getUrl();
	String image = inputs.getImage();
	if (id == null) {
	    boolean nameIsValid = (name != null)
		    && !this.service.nameValueExists(name);
	    boolean urlIsValid = (url != null)
		    && url.contains("majrh.fr")
		    && !this.service.urlValueExists(url);
	    boolean imageIsValid = image != null;
	    return nameIsValid && urlIsValid
		    && imageIsValid;
	} else {
	    if (name != null) {
		return !this.service
			.nameValueExistsUpdate(name, id)
			&& (image != null);
	    } else {
		return true;
	    }

	}

    }

}
