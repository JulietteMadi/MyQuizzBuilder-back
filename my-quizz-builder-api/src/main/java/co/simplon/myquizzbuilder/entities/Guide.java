package co.simplon.myquizzbuilder.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "guides")
public class Guide extends AbstractEntity {

    @Column(name = "url")
    private String url;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    @Override
    public String toString() {
	return "{url=" + url + ", name=" + name + ", image="
		+ image + "}";
    }
}
