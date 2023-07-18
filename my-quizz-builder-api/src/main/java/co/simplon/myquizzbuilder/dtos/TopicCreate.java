package co.simplon.myquizzbuilder.dtos;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TopicCreate {

    @NotBlank
    private String name;

    @NotEmpty
    private ArrayList<GuideCreate> guides;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public ArrayList<GuideCreate> getGuides() {
	return guides;
    }

    public void setGuides(ArrayList<GuideCreate> guides) {
	this.guides = guides;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", guides=" + guides + "}";
    }

}
