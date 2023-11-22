package co.simplon.myquizzbuilder.dtos;

public class GuideItemDto {

    private Long id;

    private String name;

    private String url;

    private String image;

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
	return "{id=" + id + ", name=" + name + ", url="
		+ url + ", image=" + image + "}";
    }

}
