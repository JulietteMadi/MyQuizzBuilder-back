package co.simplon.myquizzbuilder.dtos;

import java.util.List;

public class TopicDetailDto {

    private Long id;
    private String name;
    private List<GuideCreateDto> guides;

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

    public List<GuideCreateDto> getGuides() {
	return guides;
    }

    public void setGuides(List<GuideCreateDto> guides) {
	this.guides = guides;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", name=" + name + ", guides="
		+ guides + "}";
    }

}
