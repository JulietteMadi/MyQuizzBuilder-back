package co.simplon.myquizzbuilder.dtos;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.simplon.myquizzbuilder.customValidations.UniqueUpdateTopicName;

@UniqueUpdateTopicName
public class TopicUpdateDto {

    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 50)
    private List<@Valid GuideItemDto> guides;

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
