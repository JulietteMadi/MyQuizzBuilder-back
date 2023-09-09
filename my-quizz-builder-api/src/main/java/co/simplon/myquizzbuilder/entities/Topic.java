package co.simplon.myquizzbuilder.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "provide", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "guide_id"))
    private List<Guide> guides;

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

    public List<Guide> getGuides() {
	return guides;
    }

    public void setGuides(List<Guide> guides) {
	this.guides = guides;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", name=" + name + ", guides="
		+ guides + "}";
    }

}
