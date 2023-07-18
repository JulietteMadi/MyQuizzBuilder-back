package co.simplon.myquizzbuilder.dtos;

import javax.validation.constraints.NotBlank;

public class GuideCreate {

    @NotBlank
    private String name;

    @NotBlank
    private String url;

    @NotBlank
    private String image;

    public GuideCreate() {

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", url=" + url + ", image="
		+ image + "}";
    }

}
