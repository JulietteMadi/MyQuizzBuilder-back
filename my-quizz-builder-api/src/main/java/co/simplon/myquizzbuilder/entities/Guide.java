package co.simplon.myquizzbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guides")
public class Guide {

    @Id
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
