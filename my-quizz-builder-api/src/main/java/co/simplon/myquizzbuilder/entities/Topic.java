package co.simplon.myquizzbuilder.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "provide", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "guide_id"))
    private List<Guide> guides;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<Guide> getGuides() {
	return guides;
    }

    public void setGuides(List<Guide> guides) {
	this.guides = guides;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", guides=" + guides + "}";
    }

}
