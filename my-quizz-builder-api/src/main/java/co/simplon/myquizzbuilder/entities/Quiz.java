package co.simplon.myquizzbuilder.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
