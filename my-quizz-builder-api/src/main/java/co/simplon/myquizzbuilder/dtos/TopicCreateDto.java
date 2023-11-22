package co.simplon.myquizzbuilder.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import co.simplon.myquizzbuilder.customValidations.UniqueTopicName;

public class TopicCreateDto {

    @NotBlank
    @UniqueTopicName
    @Size(max = 100)
    private String name;

    @NotEmpty
    private List<GuideItemDto> guides;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<GuideItemDto> getGuides() {
	return guides;
    }

    public void setGuides(List<GuideItemDto> guides) {
	this.guides = guides;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", guides=" + guides + "}";
    }

}
