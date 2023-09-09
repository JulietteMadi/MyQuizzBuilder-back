package co.simplon.myquizzbuilder.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import co.simplon.myquizzbuilder.customValidations.UniqueTopicName;

public class TopicCreateDto {

    @NotBlank
    @UniqueTopicName
    private String name;

    @NotEmpty
    private List<GuideCreateDto> guides;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<GuideCreateDto> getGuides() {
	return guides;
    }

    public void setGuides(List<GuideCreateDto> guides) {
	this.guides = guides;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", guides=" + guides + "}";
    }

}
