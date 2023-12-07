package co.simplon.myquizzbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quizzes")
public class Quiz extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Manager manager;

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

    public Manager getManager() {
	return manager;
    }

    public void setManager(Manager manager) {
	this.manager = manager;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", image=" + image
		+ ", manager=" + manager + "}";
    }

}
