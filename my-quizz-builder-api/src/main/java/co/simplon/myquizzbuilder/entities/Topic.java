package co.simplon.myquizzbuilder.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
