package co.simplon.myquizzbuilder.dtos.topic;

import java.util.List;

import co.simplon.myquizzbuilder.customValidations.UniqueUpdateTopicName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@UniqueUpdateTopicName
public class TopicUpdateDto {

    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 50)
    private List<co.simplon.myquizzbuilder.dtos.topic.GuideItemDto> guides;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

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
	return "{id=" + id + ", name=" + name + ", guides="
		+ guides + "}";
    }

}
