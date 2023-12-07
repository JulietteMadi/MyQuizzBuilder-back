package co.simplon.myquizzbuilder.dtos.topic;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import co.simplon.myquizzbuilder.customValidations.UniqueTopicName;

public class TopicCreateDto {

    @NotBlank
    @UniqueTopicName
    @Size(min = 3, max = 100)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 50)
    private List<co.simplon.myquizzbuilder.dtos.topic.GuideItemDto> guides;

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